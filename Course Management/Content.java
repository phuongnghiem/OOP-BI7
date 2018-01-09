import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Content {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu system,course,lecturer,event,report;
    private JMenuItem changePW,changeTheme,dark,light;
    private JMenuItem lecturerAdd,lecturerDelete,lecturerUpdate;
    private JMenuItem courseAdd,courseUpdate,courseDelete;
    int decide1,decide2,decide3,decide4;
    private JScrollPane monitor;
    private JTextArea displayArea;
    private JTextField findCourseField,findLecturerField;
    private JPanel ButtonsHolder;
    private JButton displayCourseButton,displayLecturerButton,findCourse,findLecturer,clear;
    private JPanel courseField,lecturerField;
        public Content() {
        /* create menu items */


        lecturerAdd = new JMenuItem("Add");
        lecturerAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFramePerson frameAdd = new InforFramePerson();
                frameAdd.setNameLabel("Name of Lecturer: ");
                frameAdd.setIdLabel("ID of Lecturer: ");
                frameAdd.setMobileLabel("Mobile number:");
                frameAdd.frame.add(frameAdd.update);
                frameAdd.frame.add(frameAdd.back);
                frameAdd.back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frameAdd.frame.dispose();
                        frame.setVisible(true);
                    }
                });
                frameAdd.update.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int decide = 0;

                        TestDeserialize Test11 = new TestDeserialize();
                        ArrayList<Lecturer> outPut1 = Test11.Deserialize();
                        Iterator<Lecturer> itr1 = outPut1.iterator();
                        while (itr1.hasNext()) {
                            Lecturer beside1 = itr1.next();
                            if (beside1.id.equals(frameAdd.getIdField())) {
                                decide++;
                                frameAdd.frame.add(frameAdd.avatar);
                                frameAdd.avatar.setText("This ID already exists");
                            }
                        }
                        if (decide == 0) {

                            if(frameAdd.getNameField().equals("")||frameAdd.getIdField().equals("")||frameAdd.getMobileField().equals("")){
                                JOptionPane.showMessageDialog(null," Do not leave things blank, try again!");
                            }else {
                                outPut1.add(new Lecturer(frameAdd.getNameField(), frameAdd.getIdField(), frameAdd.getMobileField()));
                                TestSerialize test = new TestSerialize(outPut1);
                                frameAdd.setNameField("");
                                frameAdd.setIdField("");
                                frameAdd.setMobileField("");
                                frameAdd.frame.add(frameAdd.avatar);
                                frameAdd.avatar.setText("Done!");
                            }
                        }


                    }
                });
            }
        });
        lecturerDelete = new JMenuItem("Delete");

        /* add action listener to menu delete lecturer */
        lecturerDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFramePerson frameDelete = new InforFramePerson();
                frameDelete.setNameLabel("");
                frameDelete.setIdLabel("Enter the ID: ");
                frameDelete.setMobileLabel("");
                frameDelete.frame.add(frameDelete.find);
                frameDelete.frame.add(frameDelete.delete);
                frameDelete.frame.add(frameDelete.back);
                frameDelete.back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frameDelete.frame.dispose();
                        frame.setVisible(true);
                    }
                });
                /* this means we press FIND button after press DELETE MenuItem*/
                frameDelete.find.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        int decide1 = 0;

                        /* Make a new ArrayList and then import the content of file .ser into the array*/
                        TestDeserialize Test2 = new TestDeserialize();
                        final ArrayList<Lecturer> output = Test2.Deserialize();
                        /* run through array by iterator*/
                        final Iterator<Lecturer> itr = output.iterator();
                        while (itr.hasNext()) {
                            Lecturer beside = itr.next();
                            if (beside.id.equals(frameDelete.getIdField())) {
                                frameDelete.setNameLabel("Name of Lecturer:");
                                frameDelete.setIdLabel("ID of Lecturer:");
                                frameDelete.setMobileLabel("Mobile number:");
                                frameDelete.setNameField(beside.name);
                                frameDelete.setIdField(beside.id);
                                frameDelete.setMobileField(beside.mobile);
                                decide1++;
                                decide2 = 0;

                                /* this mean we press DELETE button after FIND button */
                                frameDelete.delete.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        /* decide 2 helps us to decide which
                                        situation should remove element of array */

                                        if (decide2 == 0) {
                                            itr.remove();
                                            JOptionPane.showMessageDialog(null,"ahihi");
                                        }
                                        TestSerialize test = new TestSerialize(output);
                                        frameDelete.frame.add(frameDelete.avatar);
                                        frameDelete.avatar.setText("Done!");
                                        frameDelete.setNameField("");
                                        frameDelete.setMobileField("");
                                        frameDelete.setIdField("");
                                        decide2 = 1;
                                        /* change the decide2 like at first to avoid affecting the next time */
                                    }
                                });
                            }
                        }
                        if (decide1 == 0) {
                            frameDelete.frame.add(frameDelete.avatar);
                            frameDelete.avatar.setText("No Matching");
                        }

                    }
                });

            }
        });

        /* crate Update MuneItem */
        lecturerUpdate = new JMenuItem("Update");
        lecturerUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFramePerson frameUpdate = new InforFramePerson();
                frameUpdate.setNameLabel("");
                frameUpdate.setIdLabel("Enter the ID:");
                frameUpdate.setMobileLabel("");
                frameUpdate.frame.add(frameUpdate.find);
                frameUpdate.frame.add(frameUpdate.update);
                frameUpdate.frame.add(frameUpdate.back);
                frameUpdate.back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frameUpdate.frame.dispose();
                        frame.setVisible(true);

                    }
                });
                frameUpdate.find.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int decide2 = 1;
                        TestDeserialize Test2 = new TestDeserialize();
                        final ArrayList<Lecturer> output = Test2.Deserialize();
                        final Iterator<Lecturer> itr = output.iterator();
                        while (itr.hasNext()) {
                            Lecturer beside = itr.next();
                            if (beside.id.equals(frameUpdate.getIdField())) {
                                frameUpdate.setNameLabel("Name of the Lecturer:");
                                frameUpdate.setIdLabel("ID of the Lecturer");
                                frameUpdate.setMobileLabel("Mobile number:");
                                frameUpdate.setNameField(beside.name);
                                frameUpdate.setIdField(beside.id);
                                frameUpdate.setMobileField(beside.mobile);
                                decide1 = 0;
                                frameUpdate.avatar.setVisible(false);
                                frameUpdate.update.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        if (decide1 == 0) {
                                            itr.remove();
                                        }
                                        decide1 = 3;

                                        Lecturer tempo4 = new Lecturer(frameUpdate.getNameField(), frameUpdate.getIdField(), frameUpdate.getMobileField());

                                        TestDeserialize Test4 = new TestDeserialize();
                                        final ArrayList<Lecturer> output69 = Test4.Deserialize();
                                        final Iterator<Lecturer> itr4 = output69.iterator();
                                        while (itr.hasNext()) {
                                            Lecturer beside = itr4.next();
                                            if (beside.id.equals(tempo4.id)) {
                                                frameUpdate.avatar.setText("this ID already exists!");
                                                decide1 = 2;
                                            }
                                        }
                                        if (decide1 == 3) {
                                            if(tempo4.mobile.equals("")||tempo4.id.equals("")||tempo4.name.equals("")){
                                                JOptionPane.showMessageDialog(null,"Do not leave things blank, try again!");
                                            }else {
                                                output.add(tempo4);
                                                TestSerialize test3 = new TestSerialize(output);
                                                frameUpdate.setNameField("");
                                                frameUpdate.setIdField("");
                                                frameUpdate.setMobileField("");
                                                frameUpdate.frame.add(frameUpdate.avatar);
                                                frameUpdate.avatar.setVisible(true);
                                                frameUpdate.avatar.setText("Successfully!");
                                            }
                                        }
                                    }
                                });

                            } else {
                                frameUpdate.frame.add(frameUpdate.avatar);
                                frameUpdate.avatar.setText("Not exist!");
                            }
                        }


                    }
                });

            }
        });

        courseUpdate = new JMenuItem("Update");

        courseAdd = new JMenuItem("Add");
        courseAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFrameCourse frameAdd = new InforFrameCourse();
                frameAdd.setNameLabel("Name of Course: ");
                frameAdd.setCodeLabel("Code of Course: ");
                frameAdd.setCreditLabel("Number of credits:");
                frameAdd.setLecturerLabel("Name of Lecturer:");
                frameAdd.frame.add(frameAdd.update);
                frameAdd.frame.add(frameAdd.back);
                frameAdd.back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frameAdd.frame.dispose();
                        frame.setVisible(true);
                    }
                });
                frameAdd.update.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        int decide = 0;
                        TestDeserializeCourse Test11 = new TestDeserializeCourse();
                        ArrayList<Course> outPut12 = Test11.DeserializeCourse();
                        Iterator<Course> itr1 = outPut12.iterator();

                        while (itr1.hasNext()) {
                            Course beside1 = itr1.next();
                            if (beside1.code.equals(frameAdd.getCodeField())) {
                                decide++;
                                frameAdd.frame.add(frameAdd.avatar);
                                frameAdd.avatar.setText("This Code already exists");
                            }
                        }

                        if (decide == 0) {
                            boolean bool=true;
                            try{
                                Integer.parseInt(new Integer(frameAdd.getCreditField()).toString());
                            }
                            catch (NumberFormatException e){
                                bool=false;
                            }

                            if(bool==true) {
                                if(frameAdd.getNameField().equals("")||frameAdd.getCodeField().equals("")||frameAdd.getLecturerField().equals("")){
                                    JOptionPane.showMessageDialog(null,"Do not leave text field blank, try again!");
                                }else {
                                    outPut12.add(new Course(frameAdd.getNameField(), frameAdd.getCodeField(), frameAdd.getCreditField(), frameAdd.getLecturerField()));
                                    TestSerializeCourse test = new TestSerializeCourse(outPut12);
                                    frameAdd.setNameField("");
                                    frameAdd.setCodeField("");
                                    frameAdd.setCreditField(0);
                                    frameAdd.setLecturerField("");
                                    frameAdd.frame.add(frameAdd.avatar);
                                    frameAdd.avatar.setText("Done!");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Credits must be a number, do it again!");
                            }
                        }


                    }
                });
            }
        });
        courseDelete = new JMenuItem("Delete");
        /*
        * The next step we delete a COURSE. First create an ArrayList and then
        * import the .ser file into the array. Then use the array's iterator to check
        * whether any element coincident with the one we need to delete. Once we found,
        * we delete that element in the array, then SERIALIZE the array to the .ser file.
        * If there is no such element in the array, we get "NO MATCHING".
        */
        courseDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFrameCourse frameDelete = new InforFrameCourse();
                frameDelete.setNameLabel("");
                frameDelete.setCodeLabel("Enter the CODE");
                frameDelete.setCreditLabel("");
                frameDelete.setLecturerLabel("");
                frameDelete.frame.add(frameDelete.find);
                frameDelete.frame.add(frameDelete.delete);
                frameDelete.frame.add(frameDelete.back);
                frameDelete.back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frameDelete.frame.dispose();
                        frame.setVisible(true);
                    }
                });
                frameDelete.find.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        int decide3 = 0;

                        TestDeserializeCourse Test2 = new TestDeserializeCourse();
                        final ArrayList<Course> output = Test2.DeserializeCourse();
                        final Iterator<Course> itr = output.iterator();
                        loop:
                        while (itr.hasNext()) {
                            Course beside = itr.next();
                            if (beside.code.equals(frameDelete.getCodeField())) {
                                frameDelete.setNameLabel("Name of Course:");
                                frameDelete.setCodeLabel("Code of Course:");
                                frameDelete.setCreditLabel("Number of Credits:");
                                frameDelete.setLecturerLabel("Name of Lecturer:");
                                frameDelete.setNameField(beside.name);
                                frameDelete.setCodeField(beside.code);
                                frameDelete.setCreditField(beside.credit);
                                frameDelete.setLecturerField(beside.lecturer);
                                decide3++;
                                decide4 = 0;
                                frameDelete.delete.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        if (decide4 == 0) {
                                            itr.remove();

                                        }

                                        TestSerializeCourse test = new TestSerializeCourse(output);
                                        frameDelete.frame.add(frameDelete.avatar);
                                        frameDelete.avatar.setText("Done!");
                                        frameDelete.setNameField("");
                                        frameDelete.setCodeField("");
                                        frameDelete.setCreditField(0);
                                        frameDelete.setLecturerField("");
                                        decide4 = 1;

                                    }
                                });

                            }

                        }
                        if (decide3 == 0) {
                            frameDelete.frame.add(frameDelete.avatar);
                            frameDelete.avatar.setText("No Matching");
                        }

                    }
                });

            }
        });

        /* The update process is actually the combine of Find, Delete and Add, consecutively.
         * But you if update a Course infor (here is the code) coincident we another one,
         * you get noti that it already exists */
        courseUpdate = new JMenuItem("Update");
        courseUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFrameCourse frameUpdate = new InforFrameCourse();
                frameUpdate.setNameLabel("");
                frameUpdate.setCodeLabel("Enter the CODE");
                frameUpdate.setCreditLabel("");
                frameUpdate.setLecturerLabel("");
                frameUpdate.frame.add(frameUpdate.find);
                frameUpdate.frame.add(frameUpdate.update);
                frameUpdate.frame.add(frameUpdate.back);
                frameUpdate.back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frameUpdate.frame.dispose();
                        frame.setVisible(true);

                    }
                });
                frameUpdate.find.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int decide4 = 1;
                        TestDeserializeCourse Test2 = new TestDeserializeCourse();
                        final ArrayList<Course> output = Test2.DeserializeCourse();
                        final Iterator<Course> itr = output.iterator();
                        while (itr.hasNext()) {
                            Course beside = itr.next();
                            if (beside.code.equals(frameUpdate.getCodeField())) {
                                frameUpdate.setNameLabel("Name of the course");
                                frameUpdate.setCodeLabel("Code of the course");
                                frameUpdate.setCreditLabel("Number of credits:");
                                frameUpdate.setLecturerLabel("Name of lecturer:");
                                frameUpdate.setNameField(beside.name);
                                frameUpdate.setCodeField(beside.code);
                                frameUpdate.setCreditField(beside.credit);
                                frameUpdate.setLecturerField(beside.lecturer);
                                decide3 = 0;
                                frameUpdate.avatar.setVisible(false);
                                frameUpdate.update.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        if (decide3 == 0) {
                                            itr.remove();
                                        }
                                        decide3 = 3;


                                        Course tempo4 = new Course(frameUpdate.getNameField(), frameUpdate.getCodeField(), frameUpdate.getCreditField(),frameUpdate.getLecturerField());

                                        TestDeserializeCourse Test4 = new TestDeserializeCourse();
                                        final ArrayList<Course> output96 = Test4.DeserializeCourse();
                                        final Iterator<Course> itr4 = output96.iterator();
                                        while (itr.hasNext()) {
                                            Course beside = itr4.next();
                                            if (beside.code.equals(tempo4.code)) {
                                                frameUpdate.avatar.setText("this CODE already exists!");
                                                decide3 = 2;
                                            }
                                        }
                                        if (decide3 == 3) {
                                            if(frameUpdate.getNameField().equals("")||frameUpdate.getCodeField().equals("")||frameUpdate.getLecturerField().equals("")){
                                                JOptionPane.showMessageDialog(null,"Do not leave text field blank, try again!");
                                            }else {
                                                output.add(tempo4);
                                                TestSerializeCourse test3 = new TestSerializeCourse(output);
                                                frameUpdate.setNameField("");
                                                frameUpdate.setCodeField("");
                                                frameUpdate.setCreditField(0);
                                                frameUpdate.frame.add(frameUpdate.avatar);
                                                frameUpdate.avatar.setVisible(true);
                                                frameUpdate.avatar.setText("Successfully!");
                                            }
                                        }
                                    }
                                });

                            } else {
                                frameUpdate.frame.add(frameUpdate.avatar);
                                frameUpdate.avatar.setText("Not exist!");
                            }
                        }


                    }
                });

            }
        });


        /* create menus */
        system = new JMenu("Theme");
        changePW = new JMenuItem("Change Password");
        changeTheme = new JMenuItem("Change Theme");

        /* settings to change theme, which is changes in colors of buttons and labels */
        dark = new JMenuItem("Dark");
        light= new JMenuItem("Light");
        system.add(dark);
        system.add(light);
        dark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayArea.setBackground(Color.LIGHT_GRAY);
                findCourse.setBackground(Color.DARK_GRAY);
                findCourseField.setBackground(Color.LIGHT_GRAY);
                findLecturer.setBackground(Color.DARK_GRAY);
                findLecturerField.setBackground(Color.LIGHT_GRAY);
                displayCourseButton.setBackground(Color.DARK_GRAY);
                displayLecturerButton.setBackground(Color.DARK_GRAY);
                clear.setBackground(Color.DARK_GRAY);
            }
        });
        light.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayArea.setBackground(Color.WHITE);
                findCourse.setBackground(Color.WHITE);
                findCourseField.setBackground(Color.WHITE);
                findLecturerField.setBackground(Color.WHITE);
                findLecturer.setBackground(Color.WHITE);
                displayCourseButton.setBackground(Color.WHITE);
                displayLecturerButton.setBackground(Color.WHITE);
                clear.setBackground(Color.WHITE);
            }
        });
        displayArea= new JTextArea(10,20);
        /*this class helps us to redirect the system.out from console to the JtextArea*/
            PrintStream printStream = new PrintStream(new CustomOutputStream(displayArea));
            System.setOut(printStream);
            System.setErr(printStream);
            displayArea.setText("");
            System.out.println("Enter any thing you want to search about courses in course search field");
            System.out.println("Enter any thing you want to search about lecturers in lecture search fiels");
            System.out.println("You can only modify information if you know their CODE or ID");
            System.out.println("");
            System.out.println("TOPIC 2: Courses Management System");
            System.out.println("GROUP 3 - USTH GEN7");
            System.out.println("Nguyen Dinh Mau BI7-106");
            System.out.println("Ha Minh Huong BI7-079");
            System.out.println("Do Thu Anh BI7-006");
            System.out.println("Cao Phuong linh BI7-091");
            System.out.println("Nguyen Dinh Mau BI7-106");


        monitor = new JScrollPane(displayArea);
        monitor.setSize(300,160);
        ButtonsHolder = new JPanel(new GridLayout(5,1));
        findCourse = new JButton("Filter Courses");
        findCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        courseField         = new JPanel(new GridLayout(2,1));
        findCourse          = new JButton("Filter Course");
        findCourseField     = new JTextField(10);
        courseField.add(findCourseField);
        courseField.add(findCourse);

        lecturerField     = new JPanel(new GridLayout(2,1));
        findLecturer      = new JButton("Filter Lecturers");
        findLecturerField = new JTextField(10);
        lecturerField.add(findLecturerField);
        lecturerField.add(findLecturer);

        clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayArea.setText("");
                System.out.println("Enter any thing you want to search about courses in course search field");
                System.out.println("Enter any thing you want to search about lecturers in lecture search fiels");
                System.out.println("You can only modify information if you know their CODE or ID");
                System.out.println("");
                System.out.println("Node that if you get EMPTY NOTI at the FIRST time, dont bother it!");
                System.out.println(" 0 of number of credits means that course its not in ECT Program");
                System.out.println("");
                System.out.println("TOPIC 2: Courses Management System");
                System.out.println("GROUP 3 - USTH GEN7");
                System.out.println("Nguyen Dinh Mau BI7-106");
                System.out.println("Ha Minh Huong BI7-079");
                System.out.println("Do Thu Anh BI7-006");
                System.out.println("Cao Phuong linh BI7-091");
                System.out.println("Nguyen Dinh Mau BI7-106");

            }
        });

        displayCourseButton   =new JButton("Display Courses");
        displayLecturerButton = new JButton("Display Lecturers");
        ButtonsHolder.add(courseField);
        ButtonsHolder.add(lecturerField);
        ButtonsHolder.add(displayCourseButton);
        ButtonsHolder.add(displayLecturerButton);
        ButtonsHolder.add(clear);

        /* these buttons below help us to find anything you remember
         * about the infor of the COURSE or the LECTURER that you want to search */
        findCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayArea.setText("");
                System.out.println("ALL COURSES RELATED: ");
                String var = findCourseField.getText();
                TestDeserializeCourse TEST55 = new TestDeserializeCourse();
                ArrayList<Course> test55 = TEST55.DeserializeCourse();
                for (int i=0;i<test55.size();i++){
                    if(test55.get(i).lecturer.equals(var)||test55.get(i).name.equals(var)||test55.get(i).code.equals(var)||String.valueOf(test55.get(i).credit).equals(var)){
                        System.out.println("------------------");
                        System.out.println("Name: "+test55.get(i).name);
                        System.out.println("Code: "+test55.get(i).code);
                        System.out.println("Credits: "+test55.get(i).credit);
                        System.out.println("Lecturer: "+test55.get(i).lecturer);
                    }
                }
            }
        });


        findLecturer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayArea.setText("");
                System.out.println("ALL LECTURER RELATED: ");
                String var1 = findLecturerField.getText();
                TestDeserialize TEST77 = new TestDeserialize();
                ArrayList<Lecturer> test77 = TEST77.Deserialize();
                for(int i=0;i<test77.size();i++){
                    if(test77.get(i).name.equals(var1)||test77.get(i).id.equals(var1)||test77.get(i).mobile.equals(var1)){
                        System.out.println("------------------");
                        System.out.println("Name: "+test77.get(i).name);
                        System.out.println("ID: "+test77.get(i).id);
                        System.out.println("Mobile: "+test77.get(i).mobile);

                    }
                }
            }
        });


/* these 2 buttons below show all the courses and lecturers into the JtextArea */
        displayCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int none = 0;
                displayArea.setText("");
                TestDeserializeCourse test18 = new TestDeserializeCourse();
                ArrayList<Course> display1 =  test18.DeserializeCourse();
                for(int i=0;i<display1.size();i++){
                    if(!display1.get(i).code.equals("xyz-1056998-cg")&&!display1.get(i).code.equals("")&&!display1.get(i).name.equals("")){
                       System.out.println("------------------");
                       System.out.println("Name: "+display1.get(i).name);
                       System.out.println("Code: "+display1.get(i).code);
                       System.out.println("Credits: "+display1.get(i).credit);
                       System.out.println("Lecturer: "+display1.get(i).lecturer);
                       none++;

                    }

                }
                if(none==0){
                    System.out.println("EMPTY");
                }

            }
        });

        displayLecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int none = 0;
                displayArea.setText("");
                TestDeserialize test19 = new TestDeserialize();
                ArrayList<Lecturer> display2 = test19.Deserialize();
                for(int i=0;i<display2.size();i++){
                    if(!display2.get(i).id.equals("000abz109-72bfg")&&!display2.get(i).mobile.equals("")&&!display2.get(i).id.equals("")&&!display2.get(i).name.equals("")){
                        System.out.println("----------------------");
                        System.out.println("Name: "+display2.get(i).name);
                        System.out.println("ID: "+display2.get(i).id);
                        System.out.println("Mobile number: "+display2.get(i).mobile);
                        none++;
                    }
                }
                if(none==0){
                    System.out.println("EMPTY ");
                }
            }
        });

        /* some initializing for Items */
        course = new JMenu("Course");
        lecturer=new JMenu("Lecturer");
        event  = new JMenu("Event");
        report = new JMenu("Report");

        /* add items to menu */
        lecturer.add(lecturerAdd);
        lecturer.add(lecturerDelete);
        lecturer.add(lecturerUpdate);

        course.add(courseAdd);
        course.add(courseDelete);
        course.add(courseUpdate);

        menuBar = new JMenuBar();
        menuBar.add(system);
        menuBar.add(course);
        menuBar.add(lecturer);
        menuBar.add(event);
        menuBar.add(report);

        frame = new JFrame("Control Panel");
        frame.setLocation(250,400);
        frame.setSize(650,300);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.add(menuBar,BorderLayout.NORTH);
        frame.add(ButtonsHolder,BorderLayout.WEST);
        frame.add(monitor,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

}
