package game.GUI;

import game.competition.Competition;

public class UpdateGuiThread implements Runnable {
    private CompPan compPanel;

    public UpdateGuiThread(CompPan compPanel){
        this.compPanel = compPanel;
    }

    public void run(){
        Competition comp = compPanel.getCompetition();
        while(comp.hasActiveCompetitors()){
            compPanel.repaint();
            compPanel.revalidate();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
