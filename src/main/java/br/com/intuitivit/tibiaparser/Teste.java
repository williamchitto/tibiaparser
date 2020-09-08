package br.com.intuitivit.tibiaparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.intuitivit.tibiaparser.model.Guild;
import br.com.intuitivit.tibiaparser.model.PlayersOnline;
import br.com.intuitivit.tibiaparser.model.RankingXP;

public class Teste {

	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Document doc = Jsoup.connect(
		 * "https://secure.tibia.com/community/?subtopic=characters&name=hazer%20heal").
		 * get(); //System.out.println(doc.title()); Elements newsHeadlines =
		 * doc.select(".BoxContent a"); for (Element headline : newsHeadlines) {
		 * System.out.println(headline.text()); }
		 */

		/*
		 * Document doc = Jsoup.connect(
		 * "https://secure.tibia.com/community/?subtopic=guilds&page=view&GuildName=Colossus&character=Atsuhike&action=characters"
		 * ).get(); Elements newsHeadlines = doc.select("td"); for (Element headline :
		 * newsHeadlines) { System.out.println(headline.text()); }
		 */

		/*
		 * Document doc = Jsoup.connect(
		 * "https://secure.tibia.com/community/?subtopic=guilds&page=view&GuildName=Colossus&character=Atsuhike&action=characters"
		 * ).get(); Elements newsHeadlines =
		 * doc.select(".TableContentAndRightShadow tr a");
		 * 
		 * for (Element headline : newsHeadlines) { System.out.println(headline.text());
		 * }
		 */
		List<PlayersOnline> online = new Teste().coletarDadosOnline();
		for (PlayersOnline playersOnline : online) {
			if(playersOnline.getPvpType().equals("Optional PvP")) {
			coletarDadosXp(playersOnline.getWorld());
			}
		//coletarDadosChar("Dracane");
			
			//new Teste().coletarDadosGuilds(playersOnline.getWorld());
			
		}
		//new Teste().coletarDadosGuilds("Belobra");
		
		
		//https://secure.tibia.com/community/?subtopic=guilds&page=view&GuildName=Drakaris

	}
	
	public List<Guild>  coletarDadosGuilds(String world) throws IOException {
		List<Guild> listaGuild = new ArrayList<Guild>();
		List<String> ignorar = new ArrayList<String>();
		ignorar.add("Logo");
		ignorar.add("Description");
		ignorar.add("");
		Document doc = Jsoup.connect("https://www.tibia.com/community/?subtopic=guilds&world="+world).get();
		Elements newsHeadlines = doc.select(".BoxContent .Table3 tr td b");

		PlayersOnline playersOnline = new PlayersOnline();
		int posicao = 0;
		for (Element headline : newsHeadlines) {
			String linha = headline.text();
			if (!ignorar.contains(linha)) {
			System.out.println("posicao ="+posicao+ " - " +linha);
			if(linha.equals("")) {
				System.out.println("Opa carai");
			}
			}
			posicao++;
		}
		return listaGuild;
	}
		
	public List<PlayersOnline>  coletarDadosOnline() throws IOException {
		List<PlayersOnline> listaOnline = new ArrayList<PlayersOnline>();

		List<String> ignorar = new ArrayList<String>();
		ignorar.add("Regular Worlds");
		ignorar.add("World");
		ignorar.add("Online");
		ignorar.add("Location");
		ignorar.add("PvP Type");
		ignorar.add("BattlEye");
		ignorar.add("Additional Information");
		//ignorar.add("Tournament Worlds");

		Document doc = Jsoup.connect("https://www.tibia.com/community/?subtopic=worlds").get();
		Elements newsHeadlines = doc.select(".TableContent tbody tr td");

		PlayersOnline playersOnline = new PlayersOnline();
		int posicao = 0;
		for (Element headline : newsHeadlines) {
			String linha = headline.text();

			if (linha.startsWith("Overall Maximum")) {
				continue;
			}
			if(linha.startsWith("Tournament Worlds")) {
				break;
			}
			 System.out.println(linha);
			if (!ignorar.contains(linha)) {

				posicao++;
				if (posicao == 1) {
					playersOnline.setWorld(linha);
				}
				if (posicao == 2) {
					playersOnline.setOnline(Integer.parseInt(linha.replace(",", "")));
				}
				if (posicao == 3) {
					playersOnline.setLocation(linha);

				}
				if (posicao == 4) {
					playersOnline.setPvpType(linha);
				}
				if (posicao == 5) {
					String link = headline.select("img").attr("src");
					if (link.equals(
							"https://ssl-static-tibia.akamaized.net/images/global/content/icon_battleyeinitial.gif")) {
						playersOnline.setBattlEye(true);
					} else {
						playersOnline.setBattlEye(false);
					}
				}
				if (posicao == 6) {
					playersOnline.setAdditionalInformation(linha);
					posicao = 0;
					listaOnline.add(playersOnline);
					playersOnline= new PlayersOnline();
					
				}
			}
		}
		
		return listaOnline;
	}

	private static void coletarDadosXp(String world) throws IOException, InterruptedException {
		List<RankingXP> listXP = new ArrayList<RankingXP>();

		List<String> ignorar = new ArrayList<String>();
		ignorar.add("Rank");
		ignorar.add("Name");
		ignorar.add("Vocation");
		ignorar.add("Level");
		ignorar.add("World");
		ignorar.add("Points");
		ignorar.add("» Pages: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 » Results: 1000");

		for (int i = 1; i <= 12; i++) {
			//Thread.sleep(3000);
			Document doc = null;
			try {
			 doc = Jsoup.connect(
				
					"https://www.tibia.com/community/?subtopic=highscores&world="+world+"&list=experience&profession=2&currentpage="
							+ i).get();
			
			}catch ( org.jsoup.HttpStatusException e) {
				Thread.sleep(15000);
				 doc = Jsoup.connect(
							"https://www.tibia.com/community/?subtopic=highscores&world="+world+"&list=experience&profession=2&currentpage="
									+ i).get();
			}
			Elements newsHeadlines = doc.select(".TableContentAndRightShadow tr td");

			RankingXP rankingXP = new RankingXP();
			int posicao = 0;
			for (Element headline : newsHeadlines) {
				String linha = headline.text();
					rankingXP.setWorld(world);
				if (!ignorar.contains(linha)) {
					posicao++;
					if (posicao == 1) {
						rankingXP.setRank(Integer.parseInt(linha));
					}
					if (posicao == 2) {
						rankingXP.setName(linha);
						
					}
					if (posicao == 3) {
						rankingXP.setVocation(linha);

					}
					if (posicao == 4) {
					//	rankingXP.setLvl(Integer.parseInt(linha));
					}
					if (posicao == 5) {
						rankingXP.setLvl(Integer.parseInt(linha));
					}
					if (posicao == 6) {
						rankingXP.setPoints(Long.parseLong(linha.replaceAll("\\D+", "")));
						posicao = 0;
						listXP.add(rankingXP);
						rankingXP = new RankingXP();

					}
				}
			}
		}
		
		for (RankingXP xp : listXP) {
			//System.out.println(xp);
			if(xp.getLvl()>300 && xp.getLvl()< 400) {
				coletarDadosChar(xp.getName());
			}
			
		}
	}
	
	
	public static List<Guild>  coletarDadosChar(String chars ) throws IOException {
		List<Guild> listaGuild = new ArrayList<Guild>();
		List<String> ignorar = new ArrayList<String>();
		ignorar.add("Logo");
		ignorar.add("Description");
		ignorar.add("");
		Document doc = Jsoup.connect("https://www.tibia.com/community/?subtopic=characters&name="+chars).get();
		Elements newsHeadlines = doc.select(".Border_3 tbody tr");

		PlayersOnline playersOnline = new PlayersOnline();
		int posicao = 0;
		for (Element headline : newsHeadlines) {
			String linha = headline.text();
			if (!ignorar.contains(linha)) {
				if(linha.contains("Title")) {
					break;
					}
			System.out.println("posicao ="+posicao+ " - " +linha);
		
			if(linha.equals("")) {
			//	System.out.println("Opa carai");
			}
			}
			posicao++;
		}
		return listaGuild;
	}

}
