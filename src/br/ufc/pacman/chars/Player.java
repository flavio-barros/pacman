package br.ufc.pacman.chars;

public abstract class Player {
	
	private static int pontos = 0;
	private static int vidas = 3;
	private static int fase = 1;
	private static int qtdComida = 0;
	private static boolean efeitoPilula = false;
	private static boolean foiPego = false;
	private static int contEfeitoPilula = 0;
	
	public static int velocidade = 35;
	
	private static boolean menuVisivel = true;
	private static boolean gameIniciou = false;
	private static boolean gameOver = false;
	private static boolean rankingVisivel = false;
	
	public static boolean iniciarSelecionado = true;
	public static boolean rankingSelecionado = false;
	public static boolean sairSelecionado = false;
	public static boolean pause = false;

	public static boolean isMenuVisivel() {
		return menuVisivel;
	}

	public static void setMenuVisivel(boolean menuVisivel) {
		Player.menuVisivel = menuVisivel;
	}

	public static boolean isGameIniciou() {
		return gameIniciou;
	}

	public static void setGameIniciou(boolean gameIniciou) {
		Player.gameIniciou = gameIniciou;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		Player.gameOver = gameOver;
	}

	public static void pontuar(){
		Player.setPontos(Player.getPontos()+10);
	}
	
	public static void morrer(){
		Player.setVidas(Player.getVidas()-1);
	}
	
	public static void passarDeFase(){
		Player.setFase(Player.getFase()+1);
		if(Player.fase < 5){
			Player.velocidade -= 4;
		}
	}
	
	public static int getPontos() {
		return pontos;
	}
	public static void setPontos(int pontos) {
		Player.pontos = pontos;
	}
	public static int getVidas() {
		return vidas;
	}
	public static void setVidas(int vidas) {
		Player.vidas = vidas;
	}
	public static int getFase() {
		return fase;
	}
	public static void setFase(int fase) {
		Player.fase = fase;
	}
	public static int getQtdComida() {
		return qtdComida;
	}
	public static void setQtdComida(int qtdComida) {
		Player.qtdComida = qtdComida;
	}
	public static boolean isEfeitoPilula() {
		return efeitoPilula;
	}
	public static void setEfeitoPilula(boolean efeitoPilula) {
		Player.efeitoPilula = efeitoPilula;
	}
	public static boolean isFoiPego() {
		return foiPego;
	}
	public static void setFoiPego(boolean foiPego) {
		Player.foiPego = foiPego;
	}
	public static int getContEfeitoPilula() {
		return contEfeitoPilula;
	}
	public static void setContEfeitoPilula(int contEfeitoPilula) {
		Player.contEfeitoPilula = contEfeitoPilula;
	}
	public static void comeu(){
		Player.setQtdComida(Player.getQtdComida()+1);
	}
	public static void contEfeitoPilulaIncrementa(){
		Player.setContEfeitoPilula(Player.getContEfeitoPilula()+1);
	}

	public static boolean isRankingVisivel() {
		return rankingVisivel;
	}

	public static void setRankingVisivel(boolean rankingVisivel) {
		Player.rankingVisivel = rankingVisivel;
	}
	
	public static void resetVariaveis(){
		Player.setPontos(0);
		Player.setVidas(3);
		Player.setFase(1);
		Player.setQtdComida(0);
		Player.setEfeitoPilula(false);
		Player.setFoiPego(false);
		Player.setEfeitoPilula(false);
		Player.velocidade = 35;
	}
	
}
