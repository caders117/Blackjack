package blackjackGUI;

import javax.swing.JApplet;

public class AppletBlackjack extends JApplet {
	public static void main(String[] args){
		AppletBlackjack app = new AppletBlackjack();
	}
	
	public AppletBlackjack() {
		add(new BlackjackUI());
		start();
	}
}
