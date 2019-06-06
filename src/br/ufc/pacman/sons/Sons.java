package br.ufc.pacman.sons;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class Sons {
	
	private static AudioClip clipFaseInicio;
	private static AudioClip clipMorrer;
	private static AudioClip clipComerFantasma;
	private static AudioClip clipSomDeFundo;
	private static AudioClip clipPilulaFundo;
	
	@SuppressWarnings("deprecation")
	public Sons(){
		try{
			Sons.clipFaseInicio = Applet.newAudioClip(new File("sons/faseInicio.wav").toURL());      
			Sons.clipMorrer = Applet.newAudioClip(new File("sons/morrer.wav").toURL());
			Sons.clipSomDeFundo = Applet.newAudioClip(new File("sons/pacman_chomp.wav").toURL());
			Sons.clipPilulaFundo = Applet.newAudioClip(new File("sons/comerLanche.wav").toURL());
			Sons.clipComerFantasma = Applet.newAudioClip(new File("sons/fantasmaPego.wav").toURL());
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
	}
	
	public static void somFaseInicio(){
		clipFaseInicio.play();
	}
	
	public static void somMorrer(){
		Sons.clipMorrer.play();
	}
	
	public static void somFundo(){
		Sons.clipSomDeFundo.loop();
	}
	
	public static void somFundoParar(){
		Sons.clipSomDeFundo.stop();
	}
	
	public static void somPilulaFundo(){
		Sons.clipPilulaFundo.loop();
	}
	
	public static void somPilulaFundoParar(){
		Sons.clipPilulaFundo.stop();
	}
	
	public void somComerFantasma(){
		Sons.clipComerFantasma.play();
	}
}
