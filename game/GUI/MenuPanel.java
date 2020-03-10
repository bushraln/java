package game.GUI;

import game.GameEngine;
import game.arena.Arena;
import game.arena.ArenaFactory;
import game.competition.*;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.enums.*;
import utilities.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* this is the main panel of the projet
evry button, label, combobox is created in this panel*/

public class MenuPanel extends JPanel {
    GameEngine g;
    boolean t=true;
    private String color;
    private JComboBox combochoose;
    private Skier skier;
    private Snowboarder snowboarder;
    private addCompetitormsg addcompetitormsg;
    private int maxCompetitors;
    private String name;
    private double age;
    private double maxspeed;
    private double acceleration;
    Gender gender;
    String competition;
    League league;
    Discipline discipline;
    private SkiCompetition skiCompetition;
    private SnowboardCompetition snowboardCompetition;
    private FrameMessage frameMessage;
    private Arena arena;
    public JLabel labelbuildarena;
    public JPanel panelGameScreen;
    public JPanel compPanel;
    public JLabel labelarenasize;
    public JLabel labelsnowsurface;
    public JLabel labelweathercondition;
    public JTextField textFieldarenalength;
    public JComboBox comboBoxsurface;
    public JComboBox comboBoxweather;
    public JButton buttoncreateArena;
    public JLabel labelCreateCompetition;
    public JLabel labelChooseCompetition;
    public JComboBox comboCompetition;
    public JComboBox comboBoxDiscipline;
    public JComboBox comboBoxGender;
    public JComboBox comboBoxLeague;
    public JLabel labelMax;
    public JTextField textFieldMax;
    private JLabel labelGender;
    public JLabel labelDiscipline;
    private JLabel labelLeague;
    private JLabel labelADD;
    private JLabel labelAge;
    private JLabel labelMaxspeed;
    private JLabel labelAcceleration;
    private JLabel labelName;
    private JTextField textFieldName;
    private JTextField textFieldAge;
    private JTextField textFieldMaxspeed;
    private JTextField textFieldAcceleration;
    private JButton buttonaddcompetitor;
    private JButton buttonShowInfo;
    private JButton buttonStart;
    private JButton buttonCreateCompetition;
    private buildArenaFrame buildArenaFrame;
    private JFrame frame;
    private long startClock;

    private JButton decoratorbutton;

    public MenuPanel(CompPan compPanel,JFrame frame)
    {
        super();
        setLayout(new GridLayout(0,1));
        this.frame=frame;
        //panelGameScreen = new JPanel();
        //panelGameScreen.setBounds(0, 0, 804, 605);
        this.compPanel = compPanel;
        decoratorbutton=new JButton("Decorator");
        JButton prototybutton=new JButton("copy competitor");
        JButton quickcompetition=new JButton("quickcompetition");
        JComboBox competitorslist=new JComboBox();
        JLabel ArenaTypelable=new JLabel("arena type");
        String[] Arenas={"Winter","Summer"};
        JComboBox ArenaType=new JComboBox(Arenas);



        JLabel colorLable=new JLabel("pick color");
        String[] colors={"RED","BLUE","GREEN","YELLOW","BLACK"};
        JComboBox colorbox=new JComboBox(colors);

        labelbuildarena=new JLabel("BUILD ARENA");
        labelarenasize=new JLabel("arena length");
        labelsnowsurface=new JLabel("Snow Surface");
        labelweathercondition=new JLabel("Weather Condition");
        buttonCreateCompetition=new JButton("Creat Competition");
        textFieldarenalength=new JTextField("700");

        comboBoxsurface=new JComboBox();
        comboBoxsurface.setModel(new DefaultComboBoxModel(SnowSurface.values()));

        comboBoxweather=new JComboBox();
        comboBoxweather.setModel(new DefaultComboBoxModel(WeatherCondition.values()));

        buttoncreateArena=new JButton("Build Arena");
        labelCreateCompetition=new JLabel("Create Competition");
        labelChooseCompetition=new JLabel("choose competition");
        labelMax=new JLabel("Max competitor");
        textFieldMax=new JTextField("10");

        String boxCompetition[]={"Ski","Snowboard"};
        comboCompetition=new JComboBox(boxCompetition);

        JButton quickCompetition=new JButton("Quick Competition");


        comboBoxDiscipline=new JComboBox();
        comboBoxDiscipline.setModel(new DefaultComboBoxModel(Discipline.values()));

        comboBoxGender=new JComboBox();
        comboBoxGender.setModel(new DefaultComboBoxModel(Gender.values()));

        comboBoxLeague=new JComboBox();
        comboBoxLeague.setModel(new DefaultComboBoxModel(League.values()));

        labelDiscipline=new JLabel("Discipline");
        labelGender=new JLabel("Gender");
        labelLeague=new JLabel("League");
        labelName=new JLabel("Name");
        labelAcceleration=new JLabel("acceleration");
        labelMaxspeed=new JLabel("Max Speed");
        labelAge=new JLabel("Age");
        labelADD=new JLabel("ADD COMPETITOR");
        textFieldMaxspeed=new JTextField();
        textFieldName=new JTextField();
        textFieldAge=new JTextField();
        textFieldAcceleration=new JTextField();
        buttonaddcompetitor=new JButton("add competitor");
        buttonStart=new JButton("Start Competition");
        buttonShowInfo=new JButton("Show Info");
        buttonaddcompetitor=new JButton("Add competitor");
        buttonStart=new JButton("Star Race");
        buttonShowInfo=new JButton("Show Info");
        add(labelbuildarena);
        add(ArenaTypelable);
        add(ArenaType);
        add(labelarenasize);
        add(textFieldarenalength);
        add(labelsnowsurface);
        add(comboBoxsurface);
        add(labelweathercondition);
        add(comboBoxweather);
        add(buttoncreateArena);
        add(labelCreateCompetition);
        add(labelChooseCompetition);
        add(comboCompetition);
        add(labelMax);
        add(textFieldMax);
        add(comboBoxDiscipline);
        add(labelLeague);
        add(comboBoxLeague);
        add(labelGender);
        add(comboBoxGender);
        add(quickCompetition);
        add(buttonCreateCompetition);
        add(labelADD);
        add(labelName);
        add(textFieldName);
        add(labelAge);
        add(textFieldAge);
        add(labelMaxspeed);
        add(textFieldMaxspeed);
        add(labelAcceleration);
        add(textFieldAcceleration);
        add(colorbox);
        add(buttonaddcompetitor);
        add(buttonStart);
        add(buttonShowInfo);
        color =(String)colorbox.getSelectedItem();

/* this is the create arena button.
we take all the information that the user gives us and make the arena with that information
 */
        buttoncreateArena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                WeatherCondition w = (WeatherCondition) comboBoxweather.getSelectedItem();
                String weatherStr = w.toString().toLowerCase();
                weatherStr = ((char) (weatherStr.charAt(0) - 32)) + weatherStr.substring(1);
                // CREAETE THE ARENA - ASS2
                double length = Double.parseDouble(textFieldarenalength.getText());
                int length2=Integer.parseInt(textFieldarenalength.getText());
                frame.setSize(1100,length2+100);
                String ArenaName=(String)ArenaType.getSelectedItem();

                SnowSurface s = null;
                s = (SnowSurface) comboBoxsurface.getSelectedItem();
                try {
                    ArenaFactory af = new ArenaFactory();
                    arena = af.makeArena(ArenaName);
                    arena.setLength(length);
                    arena.setSurface(s);
                    arena.setCondition(w);

                    //compPanel.removeAll();
                    //compPanel.add(new JPanelWithBackground(compPanel, "./icons/"+weatherStr+".jpg"));
                    compPanel.setImage("./icons/"+weatherStr+".jpg");
                    compPanel.repaint();
                    compPanel.revalidate();

                }catch (IllegalArgumentException a)
                {
                    JOptionPane.showMessageDialog(null, "Invalid input values! Please try again.",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        /* class listnerArenaBuild implements ActionListener{*/

          /*  public void actionPerformed(ActionEvent e){
                WeatherCondition w = (WeatherCondition) comboBoxweather.getSelectedItem();
                String weatherStr = w.toString().toLowerCase();
                weatherStr = ((char) (weatherStr.charAt(0) - 32)) + weatherStr.substring(1);
                // CREAETE THE ARENA - ASS2
                double length = Double.parseDouble(textFieldarenalength.getText());

                SnowSurface s = null;
                s = (SnowSurface) comboBoxsurface.getSelectedItem();
                try {

                     arena = new WinterArena(length, s, w);
                }catch (IllegalArgumentException a)
                {
                    buildArenaFrame=new buildArenaFrame();
                }
            }
        }
        listnerArenaBuild l=new listnerArenaBuild();
        buttoncreateArena.addActionListener(l);*/

   /*     class listnerAddcompetitor implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                if (arena ==null)
                {
                    frameMessage=new FrameMessage();
                }
            }
        }
        listnerAddcompetitor listneraddcompetitor=new listnerAddcompetitor();
        buttonaddcompetitor.addActionListener(listneraddcompetitor);*/

//        class listnerStart implements ActionListener{
//            public void actionPerformed(ActionEvent e)
//            {
//                if (arena ==null)
//                {
//                    frameMessage=new FrameMessage();
//                }
//            }
//
//
//        }
//        listnerStart listnerstart=new listnerStart();

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arena == null|| (skiCompetition==null&&snowboardCompetition==null)) {
                    JOptionPane.showMessageDialog(null, "Please Build Arena, Create Competition and add comprtitors",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    GameEngine g = GameEngine.getInstance();

                    startClock = System.currentTimeMillis();
                    compPanel.getCompetition().setStartTime(startClock);
                    g.startRace(compPanel.getCompetition());

                    //UpdateGuiThread updater = new UpdateGuiThread(compPanel);
                    //compPanel.getCompetition().setGuiThread(updater);
                    //Thread t = new Thread(updater);
                    //t.start();
                }
            }
        });
/* show info button
taking the information from evry competitior in the competition and puting them in the table
 */

        buttonShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(arena == null|| (skiCompetition==null&&snowboardCompetition==null))
                {
                    JOptionPane.showMessageDialog(null, "Please Build Arena, Create Competition and add comprtitors",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                InfoFrame table = new InfoFrame(compPanel.getCompetition());
            }
        });

        /*class listnerCreateCompetition implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                if (arena ==null)
                {
                    frameMessage=new FrameMessage();
                }
            }


        }
        listnerCreateCompetition listnercreatecompetition=new listnerCreateCompetition();
        buttonCreateCompetition.addActionListener(listnercreatecompetition);
*/




        buttonCreateCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                competition=(String) comboCompetition.getSelectedItem();

                league=(League)comboBoxLeague.getSelectedItem();

                discipline=(Discipline) comboBoxDiscipline.getSelectedItem();

                gender=(Gender) comboBoxGender.getSelectedItem();

                String maxcompetitors=textFieldMax.getText();
                maxCompetitors=Integer.parseInt(maxcompetitors);

                if (arena == null) {
                    JOptionPane.showMessageDialog(null, "Please Build Arena, Create Competition and add comprtitors",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                else {

                       if (competition.equals("Ski")) {
                        skiCompetition = new SkiCompetition(arena, maxCompetitors, discipline, league, gender);
                    compPanel.setCompetition(skiCompetition);
                    skiCompetition.setCompPanel(compPanel);

                    }
                    if (competition.equals("Snowboard")) {
                        snowboardCompetition = new SnowboardCompetition(arena, maxCompetitors, discipline, league, gender);
                        compPanel.setCompetition(snowboardCompetition);
                        snowboardCompetition.setCompPanel(compPanel);

                    }
                }
            }
        });





        buttonaddcompetitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=(String) colorbox.getSelectedItem();
                name=textFieldName.getText();
                try {
                    if (name.isEmpty() == true) {
                        throw new RuntimeException();
                    }
                }catch (Exception e4)
                {
                    JOptionPane.showMessageDialog(null, "wrong name",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }

                try {
                    age = Double.parseDouble(textFieldAge.getText());
                }catch (NumberFormatException t)
                {
                    JOptionPane.showMessageDialog(null, "wrong age",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    acceleration = Double.parseDouble(textFieldAcceleration.getText());
                }catch (NumberFormatException y)
                {
                    JOptionPane.showMessageDialog(null, "wrong acceleration",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    maxspeed = Double.parseDouble(textFieldMaxspeed.getText());
                }catch (NumberFormatException e2)
                {
                    JOptionPane.showMessageDialog(null, "wrong maxs peed",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }

                if(league.isInLeague(age)!=true)
                {
                    JOptionPane.showMessageDialog(null, "wrong age",
                            "Message", JOptionPane.INFORMATION_MESSAGE);                }
                else if (arena ==null || (skiCompetition==null&&snowboardCompetition==null))
                {
                    JOptionPane.showMessageDialog(null, "Please Build Arena, Create Competition and add comprtitors",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {

                    if(competition.equals("Ski"))
                    {

                        System.out.println(skiCompetition.getActiveCompetitors().size()*110);
                        Point location = new Point(skiCompetition.getActiveCompetitors().size()*110, 0);
                        skier=new Skier(skiCompetition,location, name,age,gender,acceleration,maxspeed,discipline, color);
                        skiCompetition.addCompetitor(skier);
                    }
                    if(competition.equals("Snowboard"))
                    {
                        Point location = new Point(snowboardCompetition.getActiveCompetitors().size()*110, 0);
                        snowboarder=new Snowboarder(snowboardCompetition,location, name,age,gender,acceleration,maxspeed,discipline, color);
                        snowboardCompetition.addCompetitor(snowboarder);
                    }

                    if(t=true&&skiCompetition!=null)
                    {
                        competitorslist.setModel(new DefaultComboBoxModel(skiCompetition.getActiveCompetitors().toArray()));
                        add(competitorslist);
                        add(prototybutton);
                        add(decoratorbutton);
                        t = false;

                    }
                    if(t=true&&snowboardCompetition!=null)
                    {
                        competitorslist.setModel(new DefaultComboBoxModel(snowboardCompetition.getActiveCompetitors().toArray()));
                        add(competitorslist);
                        add(prototybutton);
                        add(decoratorbutton);
                        t = false;

                    }

                    compPanel.repaint();
                    compPanel.revalidate();


                }

            }
        });
        prototybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Competitor competitor=(Competitor) competitorslist.getSelectedItem();
                System.out.println(competitor.toString());
                if(competitor.toString().contains("Ski"))
                {
                    Skier skiclone=((Skier)competitor).clone();
                    color =(String)colorbox.getSelectedItem();

                    skiclone.setColor(color);
                    Point location = new Point(skiCompetition.getActiveCompetitors().size()*110, 0);
                    skiclone.setLocation(location);
                    skiCompetition.addCompetitor(skiclone);
                    compPanel.repaint();
                    compPanel.revalidate();
                }
                if(competitor.toString().contains("Snow"))
                {
                    Snowboarder snowboarderclone=((Snowboarder)competitor).clone();
                    color =(String)colorbox.getSelectedItem();

                    snowboarderclone.setColor(color);
                    Point location = new Point(snowboardCompetition.getActiveCompetitors().size()*110, 0);
                    snowboarderclone.setLocation(location);
                    snowboardCompetition.addCompetitor(snowboarderclone);
                    compPanel.repaint();
                    compPanel.revalidate();
                }



            }
        });
        quickCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SkiCompetitionBuilder skiCompetitionBuilder=new SkiCompetitionBuilder();
                skiCompetition=skiCompetitionBuilder.createSkiCompetition(5);
                skiCompetition.setCompPanel(compPanel);
                compPanel.setImage("./icons/Sunny.jpg");
                compPanel.repaint();
                compPanel.revalidate();
                arena=(Arena) skiCompetition.getArena();

                compPanel.setCompetition(skiCompetition);
                competition="Ski";
            }
        });
        decoratorbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecoratorFrame decoretorPanel=new DecoratorFrame(compPanel);

            }
        });
        }

}
