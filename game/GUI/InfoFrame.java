package game.GUI;

import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* show info button
taking the information from evry competitior in the competition and puting them in the table
*/
public class InfoFrame extends JFrame {
    private Competition comp;

    InfoFrame(Competition comp) {
        List<Competitor> active = comp.getActiveCompetitors();
        List<Competitor> finished = comp.getFinishedCompetitors();
        int numOfComps = active.size() + finished.size();
        String data[][] = new String[numOfComps][8];

        int i = 0;
        i = insertData(finished, data, i, "YES");
        insertData(active, data, i, "NO");

        String column[] = {"Name", "Speed", "Max speed", "Location", "Finished","state","rank","Time Finish"};


        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 400, 500);
        JScrollPane sp = new JScrollPane(jt);
        this.add(sp);
        this.setSize(300, 400);
        this.setVisible(true);

    }

    private int insertData(List<Competitor> finished, String[][] data, int i, String isFinished) {
        Collections.sort(finished,new Comparator<Competitor>()
        {
            @Override
            public int compare(Competitor o1, Competitor o2) {
                return -1*Double.valueOf(o1.getLocation().getY()).compareTo(o2.getLocation().getY());
            }
        });

        for (Competitor co : finished) {
            //int size=finished.size();
            Sportsman c = (Sportsman) co;
            data[i][0] = c.getName();
            data[i][1] = c.getSpeed() + "";
            data[i][2] = c.getMaxSpeed() + "";
            data[i][3] = c.getLocation().getY() + "";
            data[i][4] = isFinished;
            data[i][5]=((WinterSportsman)co).getState().toString();
            data[i][6]=i+1+"";
            data[i][7]=((WinterSportsman)co).getState().getAdditionalInfo();
            //size--;
            i++;
        }
        return i;
    }
}