package osgla1;

//Name : AKSHAT GUPTA
//Roll No. : 1710110404
import com.sun.javafx.geom.AreaOp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
import javax.swing.JFrame;

public class cpuscheduling extends JFrame implements ActionListener {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int f = 0;

    String[] burt_array;
    int[] bursttime_array;

    String[] arrival_array;
    int[] arrivaltime_array;
    String[] priority_array;

    int[][] ba_arr;
    int[][] ab_arr;
    int[] aa_time;
    int[] ba_time;
    int[] p_id;
    int[] pa;
    JLabel inf10 = new JLabel();
    JLabel inf20 = new JLabel();
    JLabel inf30 = new JLabel();

    JLabel inf40 = new JLabel();
    JLabel inf50 = new JLabel();
    JLabel info6 = new JLabel();

    double difference;
    double differenceratio;
    double idleLength[];

    JLabel numOfProc = new JLabel(" processes <=6");
    JLabel burstTime = new JLabel("Busrt time of process    ");
    JLabel arrivalTime = new JLabel("Arrival time of process     ");

    JLabel priority = new JLabel("Priority of process");
    JLabel timeQuantum = new JLabel("Time Quantum");
    Choice nop = new Choice();
    JTextField bt = new JTextField();
    JTextField at = new JTextField();
    JTextField pri = new JTextField();
    JTextField tq = new JTextField();
    JCheckBox fcfs = new JCheckBox("First Come first serve");
    JCheckBox rr = new JCheckBox("round robin");
    JCheckBox p_sjf = new JCheckBox("P shortest job first");
    JCheckBox np_sjf = new JCheckBox("NP shortest job first");
    JCheckBox p_pri = new JCheckBox("P priority");
    JCheckBox np_pri = new JCheckBox("NP priority");
    JButton compute = new JButton("compute");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel(new FlowLayout());
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();
    JPanel panel9 = new JPanel();
    JFrame output = new JFrame();

    public cpuscheduling() {
        output.setLayout(new GridLayout(12, 1));

        this.setLayout(new GridLayout(9, 1));
        panel1.setLayout(new FlowLayout());
        panel1.add(numOfProc);
        nop.setPreferredSize(new Dimension(30, 30));
        nop.add("1");
        nop.add("2");
        nop.add("3");
        nop.add("4");
        nop.add("5");
        nop.add("6");

        panel1.add(nop);
        panel3.add(arrivalTime);
        at.setPreferredSize(new Dimension(300, 30));
        panel3.add(at);

        panel2.add(burstTime);
        bt.setPreferredSize(new Dimension(300, 30));
        panel2.add(bt);

        panel4.add(priority);
        pri.setPreferredSize(new Dimension(300, 30));
        panel4.add(pri);
        panel5.add(timeQuantum);
        tq.setPreferredSize(new Dimension(300, 30));
        panel5.add(tq);
        panel6.add(rr);
        panel6.add(fcfs);
        panel7.add(p_sjf);
        panel7.add(np_sjf);
        panel8.add(p_pri);
        panel8.add(np_pri);
        panel9.add(compute);

        output.setSize(1920, 1080);

        output.setVisible(false);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        this.add(panel7);
        this.add(panel8);
        this.add(panel9);
        compute.addActionListener(this);

    }

    public static void main(String[] args) {

        cpuscheduling obj = new cpuscheduling();
        obj.setVisible(true);
        obj.setSize(800, 800);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int np = Integer.parseInt(nop.getSelectedItem());
        p_id = new int[np];
        aa_time = new int[np];
        ba_time = new int[np];
        pa = new int[np];

        burt_array = bt.getText().split(",");
        arrival_array = at.getText().split(",");
        bursttime_array = new int[burt_array.length];
        arrivaltime_array = new int[arrival_array.length];
        idleLength = new double[burt_array.length];
        ba_arr = new int[burt_array.length][2];
        ab_arr = new int[burt_array.length][2];

        priority_array = pri.getText().split(",");
        for (int i = 0; i < priority_array.length; i++) {
            pa[i] = Integer.parseInt(priority_array[i]);

        }

        for (int i = 0; i < burt_array.length; i++) {
            arrivaltime_array[i] = Integer.parseInt(arrival_array[i]);
            aa_time[i] = Integer.parseInt(arrival_array[i]);

            bursttime_array[i] = Integer.parseInt(burt_array[i]);
            ba_time[i] = Integer.parseInt(burt_array[i]);
            p_id[i] = i;

        }

        for (int i = 0; i < ba_arr.length; i++) {

            ba_arr[i][0] = bursttime_array[i];
            ba_arr[i][1] = arrivaltime_array[i];
            ab_arr[i][0] = arrivaltime_array[i];
            ab_arr[i][1] = bursttime_array[i];

        }

        if (fcfs.isSelected() == true) {

            a = 1;

            fcfsscheduling op = new fcfsscheduling();
            output.add(op);
            output.add(inf10);

            repaint();

        }

        if (np_sjf.isSelected() == true) {

            b = 1;
            shortestjobscheduling ob = new shortestjobscheduling();
            output.add(ob);
            output.add(inf20);

            repaint();

        }

        if (rr.isSelected() == true) {
            c = 1;

            roundrobinscheduling ob = new roundrobinscheduling();
            output.add(ob);
            output.add(inf30);

            repaint();

        }
        if (np_pri.isSelected() == true) {

            d = 1;
            NPriority ob = new NPriority();
            output.add(ob);
            output.add(inf40);

            repaint();

        }

        if (p_sjf.isSelected() == true) {
            e = 1;

            premptivesjf ob = new premptivesjf();
            output.add(ob);

            repaint();

        }

        if (ae.getActionCommand().equals("compute")) {
            output.setVisible(true);

        }
    }

    class fcfsscheduling extends JPanel {

        Random random = new Random();

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            for (int i = 0; i < priority_array.length; i++) {
                pa[i] = Integer.parseInt(priority_array[i]);

            }

            for (int i = 0; i < burt_array.length; i++) {
                arrivaltime_array[i] = Integer.parseInt(arrival_array[i]);
                aa_time[i] = Integer.parseInt(arrival_array[i]);

                bursttime_array[i] = Integer.parseInt(burt_array[i]);
                ba_time[i] = Integer.parseInt(burt_array[i]);
                p_id[i] = i;

            }

            boolean[] check = new boolean[p_id.length];

            ArrayList<Integer> chart = new ArrayList<Integer>();
            ArrayList<Integer> track = new ArrayList<Integer>();
            int limit = 0;

            double sum = 0;
            int temp = 0;

            for (int i = 0; i < aa_time.length - 1; i++) {

                for (int j = 0; j < aa_time.length - 1 - i; j++) {
                    if (aa_time[j] > aa_time[j + 1]) {
                        int temp1 = aa_time[j];
                        aa_time[j] = aa_time[j + 1];
                        aa_time[j + 1] = temp1;

                        int temp2 = ba_time[j];
                        ba_time[j] = ba_time[j + 1];
                        ba_time[j + 1] = temp2;

                        int temp3 = p_id[j];
                        p_id[j] = p_id[j + 1];
                        p_id[j + 1] = temp3;

                    }

                }

            }
            while (chart.size() != p_id.length) {

                for (int i = 0; i < p_id.length; i++) {

                    if (aa_time[i] <= limit && check[p_id[i]] == false) {
                        chart.add(ba_time[i]);
                        track.add(p_id[i]);
                        temp = ba_time[i];
                        check[p_id[i]] = true;

                    }

                }

                limit = limit + temp;

            }

            for (int i = 0; i < chart.size(); i++) {
                sum = sum + chart.get(i);

            }
            int et = 0;
            g.drawString("" + et, 0, 40);

            double val1 = 0;

            for (int i = 0; i < chart.size(); i++) {
                double ratio = (chart.get(i)) / sum;

                double length = ratio * this.getWidth();

                g.drawRect((int) val1, 0, (int) length, 30);

                int x = (int) (length / 2);

                g.drawString("P" + track.get(i), (int) (val1 + x), 40);

                val1 = val1 + length;

            }

            for (int i = 0; i < chart.size(); i++) {
                et = et + chart.get(i);
                double ratio = et / sum;
                double length = ratio * this.getWidth();

                g.drawString(et + " ", (int) length - 20, 40);

            }

            int[] ct = new int[p_id.length];
            int[] wt = new int[p_id.length];
            int[] tat = new int[p_id.length];
            for (int i = 0; i < ct.length; i++) {
                int index = 0;
                for (int j = 0; j < track.size(); j++) {
                    if (i == track.get(j)) {
                        index = j;

                    }

                }

                int s = 0;
                for (int k = 0; k <= index; k++) {
                    s = s + chart.get(k);

                }

                ct[i] = s;

            }

            for (int i = 0; i < ct.length; i++) {
                System.out.print(ct[i] + " ");
            }

            for (int i = 0; i < tat.length; i++) {
                int index = 0;
                for (int j = 0; j < p_id.length; j++) {
                    if (i == p_id[j]) {
                        index = j;

                    }
                }

                tat[i] = ct[i] - aa_time[index];

            }

            for (int i = 0; i < tat.length; i++) {
                System.out.println(tat[i] + " ");
            }

            for (int i = 0; i < wt.length; i++) {
                int index = 0;
                for (int j = 0; j < p_id.length; j++) {
                    if (i == p_id[j]) {
                        index = j;

                    }
                }

                wt[i] = tat[i] - ba_time[index];
            }

            System.out.println("");
            for (int i = 0; i < wt.length; i++) {
                System.out.println(wt[i] + " ");

            }

            String display = " TAT of processes: ";
            for (int i = 0; i < tat.length; i++) {
                display = display + "P" + i + "-" + tat[i] + " ";

            }

            double avgtat = 0;
            for (int i = 0; i < tat.length; i++) {
                avgtat = avgtat + tat[i];

            }
            avgtat = avgtat / p_id.length;
            display = display + "  avg TAT is: " + avgtat;
            System.out.println(display);

            String display1 = " WT : ";
            for (int i = 0; i < wt.length; i++) {
                display1 = display1 + "P" + i + "-" + wt[i] + " ";

            }

            double avgwt = 0;
            for (int i = 0; i < wt.length; i++) {
                avgwt = avgwt + wt[i];

            }
            avgwt = avgwt / p_id.length;
            display1 = display1 + "  avg WT is: " + avgwt;
            System.out.println(display1);

            inf10.setText(display + "               " + display1);

        }

    }

    class shortestjobscheduling extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            if (b == 1) {

                for (int i = 0; i < priority_array.length; i++) {
                    pa[i] = Integer.parseInt(priority_array[i]);

                }

                for (int i = 0; i < burt_array.length; i++) {
                    arrivaltime_array[i] = Integer.parseInt(arrival_array[i]);
                    aa_time[i] = Integer.parseInt(arrival_array[i]);

                    bursttime_array[i] = Integer.parseInt(burt_array[i]);
                    ba_time[i] = Integer.parseInt(burt_array[i]);
                    p_id[i] = i;

                }

                boolean[] check = new boolean[p_id.length];
                ArrayList<Integer> chart = new ArrayList<Integer>();
                ArrayList<Integer> track = new ArrayList<Integer>();
                LinkedList<Integer> queue = new LinkedList<Integer>();
                int limit = 0;

                for (int i = 0; i < ba_time.length - 1; i++) {

                    for (int j = 0; j < ba_time.length - 1 - i; j++) {
                        if (ba_time[j] > ba_time[j + 1]) {
                            int temp1 = ba_time[j];
                            ba_time[j] = ba_time[j + 1];
                            ba_time[j + 1] = temp1;

                            int temp2 = aa_time[j];
                            aa_time[j] = aa_time[j + 1];
                            aa_time[j + 1] = temp2;

                            int temp3 = p_id[j];
                            p_id[j] = p_id[j + 1];
                            p_id[j + 1] = temp3;

                        }

                    }

                }
                for (int i = 0; i < ba_time.length; i++) {
                    System.out.print(ba_time[i] + " ");

                }
                System.out.println(" ");

                for (int i = 0; i < ba_time.length; i++) {
                    System.out.println(aa_time[i]);

                }
                System.out.println("this should be printed");

                for (int i = 0; i < ba_time.length; i++) {
                    System.out.println(p_id[i]);

                }

                int sum1 = 0;
                for (int i = 0; i < ba_time.length; i++) {
                    sum1 = sum1 + ba_time[i];

                }
                while (chart.size() != p_id.length) {
                    int temp = 0;

                    for (int i = 0; i < aa_time.length; i++) {
                        if (aa_time[i] <= limit && check[p_id[i]] == false) {
                            check[p_id[i]] = true;

                            chart.add(ba_time[i]);
                            temp = ba_time[i];

                            track.add(p_id[i]);

                        }
                    }

                    System.out.println(track);

                    limit = limit + temp;
                }

                double val1 = 0;
                double sum = 0;

                for (int i = 0; i < chart.size(); i++) {
                    sum = sum + chart.get(i);

                }
                for (int i = 0; i < chart.size(); i++) {
                    double ratio = chart.get(i) / sum;

                    double length = ratio * this.getWidth();
                    Random random = new Random();

                    g.drawRect((int) val1, 0, (int) length, 30);

                    int x = (int) (length / 2);

                    g.drawString("P" + track.get(i), (int) (val1 + x), 40);

                    val1 = val1 + length;

                }
                int et = 0;

                for (int i = 0; i < chart.size(); i++) {
                    et = et + chart.get(i);
                    double ratio = et / sum;
                    double length = ratio * this.getWidth();

                    g.drawString(et + " ", (int) length - 20, 40);

                }
                int[] ct = new int[p_id.length];
                int[] wt = new int[p_id.length];
                int[] tat = new int[p_id.length];
                for (int i = 0; i < ct.length; i++) {
                    int index = 0;
                    for (int j = 0; j < track.size(); j++) {
                        if (i == track.get(j)) {
                            index = j;

                        }

                    }

                    int s = 0;
                    for (int k = 0; k <= index; k++) {
                        s = s + chart.get(k);

                    }

                    ct[i] = s;

                }

                for (int i = 0; i < ct.length; i++) {
                    System.out.print(ct[i] + " ");
                }

                for (int i = 0; i < tat.length; i++) {
                    int index = 0;
                    for (int j = 0; j < p_id.length; j++) {
                        if (i == p_id[j]) {
                            index = j;

                        }
                    }

                    tat[i] = ct[i] - aa_time[index];

                }

                for (int i = 0; i < tat.length; i++) {
                    System.out.println(tat[i] + " ");
                }

                for (int i = 0; i < wt.length; i++) {
                    int index = 0;
                    for (int j = 0; j < p_id.length; j++) {
                        if (i == p_id[j]) {
                            index = j;

                        }
                    }

                    wt[i] = tat[i] - ba_time[index];
                }

                System.out.println("");
                for (int i = 0; i < wt.length; i++) {
                    System.out.println(wt[i] + " ");

                }

                String display = " TAT of processes: ";
                for (int i = 0; i < tat.length; i++) {
                    display = display + "P" + i + "-" + tat[i] + " ";

                }

                double avgtat = 0;
                for (int i = 0; i < tat.length; i++) {
                    avgtat = avgtat + tat[i];

                }
                avgtat = avgtat / p_id.length;
                display = display + "  avg TAT : " + avgtat;
                System.out.println(display);

                String display1 = " WT ";
                for (int i = 0; i < wt.length; i++) {
                    display1 = display1 + "P" + i + "-" + wt[i] + " ";

                }

                double avgwt = 0;
                for (int i = 0; i < wt.length; i++) {
                    avgwt = avgwt + wt[i];

                }
                avgwt = avgwt / p_id.length;
                display1 = display1 + "  average WT is: " + avgwt;
                System.out.println(display1);

                inf20.setText(display + "        " + display1);

            }

        }

    }

    class roundrobinscheduling extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (c == 1) {

                boolean[] inReady = new boolean[p_id.length];
                int t = Integer.parseInt(tq.getText());

                for (int i = 0; i < aa_time.length - 1; i++) {

                    for (int j = 0; j < aa_time.length - 1 - i; j++) {
                        if (aa_time[j] > aa_time[j + 1]) {
                            int temp1 = aa_time[j];
                            aa_time[j] = aa_time[j + 1];
                            aa_time[j + 1] = temp1;

                            int temp2 = ba_time[j];
                            ba_time[j] = ba_time[j + 1];
                            ba_time[j + 1] = temp2;

                            int temp3 = p_id[j];
                            p_id[j] = p_id[j + 1];
                            p_id[j + 1] = temp3;

                        }

                    }

                }
                int limit = 0;

                ArrayList<Integer> chart = new ArrayList<Integer>();
                ArrayList<Integer> track = new ArrayList<Integer>();

                LinkedList<Integer> ready = new LinkedList<Integer>();
                int temp = 0;
                if (aa_time[temp] <= limit) {
                    if (ba_time[temp] > t) {
                        ba_time[temp] = ba_time[temp] - t;
                        chart.add(t);
                        track.add(temp);

                        limit = limit + t;

                    } else {
                        chart.add(ba_time[temp]);
                        track.add(temp);
                        limit = limit + ba_time[temp];
                        ba_time[temp] = 0;

                    }
                }

                for (int i = 1; i < p_id.length; i++) {
                    if (aa_time[i] <= limit && inReady[p_id[i]] == false) {
                        ready.addLast(p_id[i]);

                        inReady[p_id[i]] = true;
                    }

                }

                while (!ready.isEmpty()) {

                    if (ba_time[temp] != 0) {
                        ready.addLast(p_id[temp]);

                    }
                    int temp2 = ready.removeFirst();
                    for (int i = 0; i < p_id.length; i++) {
                        if (p_id[i] == temp2) {
                            temp = i;

                        }
                    }
                    if (aa_time[temp] <= limit) {
                        if (ba_time[temp] > t) {
                            ba_time[temp] = ba_time[temp] - t;
                            chart.add(t);
                            track.add(temp);
                            System.out.println(chart);

                            limit = limit + t;

                        } else {
                            chart.add(ba_time[temp]);
                            System.out.println(chart);
                            track.add(temp);
                            limit = limit + ba_time[temp];
                            ba_time[temp] = 0;

                        }
                    }

                    for (int i = 1; i < p_id.length; i++) {
                        if (aa_time[i] <= limit && inReady[p_id[i]] == false) {
                            ready.addLast(p_id[i]);
                            inReady[p_id[i]] = true;

                        }

                    }

                }

                chart.add(ba_time[temp]);
                track.add(temp);

                int et = 0;
                g.drawString("" + et, 0, 40);
                double val1 = 0;
                double sum = 0;

                for (int i = 0; i < chart.size(); i++) {
                    sum = sum + chart.get(i);

                }

                for (int i = 0; i < chart.size(); i++) {
                    double ratio = chart.get(i) / sum;

                    double length = ratio * this.getWidth();

                    Random random = new Random();

                    g.drawRect((int) val1, 0, (int) length, 30);

                    int x = (int) (length / 2);

                    g.drawString("P" + track.get(i), (int) (val1 + x), 40);

                    val1 = val1 + length;

                }
                for (int i = 0; i < chart.size(); i++) {
                    et = et + chart.get(i);
                    double ratio = et / sum;
                    double length = ratio * this.getWidth();

                    g.drawString(et + " ", (int) length - 20, 40);

                }

                int[] ct = new int[p_id.length];
                int[] wt = new int[p_id.length];
                int[] tat = new int[p_id.length];
                for (int i = 0; i < ct.length; i++) {
                    int index = 0;
                    for (int j = 0; j < track.size(); j++) {
                        if (i == track.get(j)) {
                            index = j;

                        }

                    }

                    int s = 0;
                    for (int k = 0; k <= index; k++) {
                        s = s + chart.get(k);

                    }

                    ct[i] = s;

                }

                for (int i = 0; i < ct.length; i++) {
                    System.out.print(ct[i] + " ");
                }

                for (int i = 0; i < tat.length; i++) {
                    int index = 0;
                    for (int j = 0; j < p_id.length; j++) {
                        if (i == p_id[j]) {
                            index = j;

                        }
                    }

                    tat[i] = ct[i] - arrivaltime_array[index];

                }

                for (int i = 0; i < tat.length; i++) {
                    System.out.println(tat[i] + " ");
                }

                for (int i = 0; i < wt.length; i++) {
                    int index = 0;
                    for (int j = 0; j < p_id.length; j++) {
                        if (i == p_id[j]) {
                            index = j;

                        }
                    }

                    wt[i] = tat[i] - bursttime_array[index];
                }

                System.out.println("");
                for (int i = 0; i < wt.length; i++) {
                    System.out.println(wt[i] + " ");

                }

                String display = " TAT of processes: ";
                for (int i = 0; i < tat.length; i++) {
                    display = display + "P" + i + "-" + tat[i] + " ";

                }

                double avgtat = 0;
                for (int i = 0; i < tat.length; i++) {
                    avgtat = avgtat + tat[i];

                }
                avgtat = avgtat / p_id.length;
                display = display + "  average TAT is: " + avgtat;
                System.out.println(display);

                String display1 = " WT of processes: ";
                for (int i = 0; i < wt.length; i++) {
                    display1 = display1 + "P" + i + "-" + wt[i] + " ";

                }

                double avgwt = 0;
                for (int i = 0; i < wt.length; i++) {
                    avgwt = avgwt + wt[i];

                }
                avgwt = avgwt / p_id.length;
                display1 = display1 + "  average WT is: " + avgwt;
                System.out.println(display1);

                inf30.setText(display + " Round Robin  " + display1);

            }

        }

    }

    class NPriority extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

            if (d == 1) {
                boolean check[] = new boolean[p_id.length];
                ArrayList<Integer> chart = new ArrayList<Integer>();
                ArrayList<Integer> track = new ArrayList<Integer>();
                int limit = 0;
                ArrayList<Integer> cancome = new ArrayList<Integer>();
                ArrayList<Integer> sequence = new ArrayList<Integer>();

                for (int i = 0; i < pa.length - 1; i++) {

                    for (int j = 0; j < pa.length - 1 - i; j++) {
                        if (pa[j] > pa[j + 1]) {
                            int temp1 = pa[j];
                            pa[j] = pa[j + 1];
                            pa[j + 1] = temp1;

                            int temp4 = ba_time[j];
                            ba_time[j] = ba_time[j + 1];
                            ba_time[j + 1] = temp4;

                            int temp2 = aa_time[j];
                            aa_time[j] = aa_time[j + 1];
                            aa_time[j + 1] = temp2;

                            int temp3 = p_id[j];
                            p_id[j] = p_id[j + 1];
                            p_id[j + 1] = temp3;

                        }
                    }
                }
                int temp = 0;
                while (track.size() != p_id.length) {
                    for (int i = 0; i < p_id.length; i++) {

                        if (aa_time[i] <= limit && check[p_id[i]] == false) {
                            int index = 0;

                            int temp2 = pa[i];
                            for (int j = 0; j < p_id.length; j++) {
                                if (pa[j] == temp2) {
                                    index = j;

                                }
                            }

                            chart.add(ba_time[index]);

                            track.add(p_id[index]);

                            temp = ba_time[index];

                            check[p_id[i]] = true;

                        }
                    }

                    limit = limit + temp;

                }

                System.out.println(track);

                int et = 0;
                g.drawString("" + et, 0, 40);

                double val1 = 0;
                double sum = 0;

                for (int i = 0; i < chart.size(); i++) {
                    sum = sum + chart.get(i);

                }
                for (int i = 0; i < chart.size(); i++) {
                    double ratio = chart.get(i) / sum;

                    double length = ratio * this.getWidth();

                    Random random = new Random();

                    g.drawRect((int) val1, 0, (int) length, 30);

                    int x = (int) (length / 2);

                    g.drawString("P" + track.get(i), (int) (val1 + x), 40);

                    val1 = val1 + length;

                }

                for (int i = 0; i < chart.size(); i++) {
                    et = et + chart.get(i);
                    double ratio = et / sum;
                    double length = ratio * this.getWidth();

                    g.drawString(et + " ", (int) length - 20, 40);

                }

                int[] ct = new int[p_id.length];
                int[] wt = new int[p_id.length];
                int[] tat = new int[p_id.length];
                for (int i = 0; i < ct.length; i++) {
                    int index = 0;
                    for (int j = 0; j < track.size(); j++) {
                        if (i == track.get(j)) {
                            index = j;

                        }

                    }

                    int s = 0;
                    for (int k = 0; k <= index; k++) {
                        s = s + chart.get(k);

                    }

                    ct[i] = s;

                }

                for (int i = 0; i < ct.length; i++) {
                    System.out.print(ct[i] + " ");
                }

                for (int i = 0; i < tat.length; i++) {
                    int index = 0;
                    for (int j = 0; j < p_id.length; j++) {
                        if (i == p_id[j]) {
                            index = j;

                        }
                    }

                    tat[i] = ct[i] - aa_time[index];

                }

                for (int i = 0; i < tat.length; i++) {
                    System.out.println(tat[i] + " ");
                }

                for (int i = 0; i < wt.length; i++) {
                    int index = 0;
                    for (int j = 0; j < p_id.length; j++) {
                        if (i == p_id[j]) {
                            index = j;

                        }
                    }

                    wt[i] = tat[i] - ba_time[index];
                }

                System.out.println("");
                for (int i = 0; i < wt.length; i++) {
                    System.out.println(wt[i] + " ");

                }

                String display = " TAT of processes: ";
                for (int i = 0; i < tat.length; i++) {
                    display = display + "P" + i + "-" + tat[i] + " ";

                }

                double avgtat = 0;
                for (int i = 0; i < tat.length; i++) {
                    avgtat = avgtat + tat[i];

                }
                avgtat = avgtat / p_id.length;
                display = display + "  average TAT is: " + avgtat;
                System.out.println(display);

                String display1 = " WT of processes: ";
                for (int i = 0; i < wt.length; i++) {
                    display1 = display1 + "P" + i + "-" + wt[i] + " ";

                }

                double avgwt = 0;
                for (int i = 0; i < wt.length; i++) {
                    avgwt = avgwt + wt[i];

                }
                avgwt = avgwt / p_id.length;
                display1 = display1 + "  average WT is: " + avgwt;
                System.out.println(display1);

                inf40.setText(display + "                                NP-Priority                                                             " + display1);

            }

        }

    }

    class premptivesjf extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

        }

    }

}
