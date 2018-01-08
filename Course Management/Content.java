import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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



                            outPut1.add(new Lecturer(frameAdd.getNameField(), frameAdd.getIdField(), frameAdd.getMobileField()));
                            TestSerialize test = new TestSerialize(outPut1);
                            frameAdd.setNameField("");
                            frameAdd.setIdField("");
                            frameAdd.setMobileField("");
                            frameAdd.frame.add(frameAdd.avatar);
                            frameAdd.avatar.setText("Done!");
                        }


                    }
                });
            }
        });
        lecturerDelete = new JMenuItem("Delete");
        lecturerDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFramePerson frameDelete = new InforFramePerson();
                frameDelete.setNameLabel("Name of Lecturer:");
                frameDelete.setIdLabel("ID of Lecturer:");
                frameDelete.setMobileLabel("Mobile number:");
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

                        int decide1 = 0;

                        TestDeserialize Test2 = new TestDeserialize();
                        final ArrayList<Lecturer> output = Test2.Deserialize();
                        final Iterator<Lecturer> itr = output.iterator();
                        loop:
                        while (itr.hasNext()) {
                            Lecturer beside = itr.next();
                            if (beside.id.equals(frameDelete.getIdField())) {
                                frameDelete.setNameField(beside.name);
                                frameDelete.setIdField(beside.id);
                                frameDelete.setMobileField(beside.mobile);
                                decide1++;
                                decide2 = 0;
                                frameDelete.delete.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        if (decide2 == 0) {
                                            itr.remove();

                                        }


                                        TestSerialize test = new TestSerialize(output);
                                        frameDelete.frame.add(frameDelete.avatar);
                                        frameDelete.avatar.setText("Done!");
                                        frameDelete.setNameField("");
                                        frameDelete.setMobileField("");
                                        frameDelete.setIdField("");
                                        decide2 = 1;

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
        lecturerUpdate = new JMenuItem("Update");
        lecturerUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFramePerson frameUpdate = new InforFramePerson();
                frameUpdate.setNameLabel("Name of the Lecturer:");
                frameUpdate.setIdLabel("ID of the Lecturer");
                frameUpdate.setMobileLabel("Mobile number:");
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
                                        final ArrayList<Lecturer> output = Test4.Deserialize();
                                        final Iterator<Lecturer> itr4 = output.iterator();
                                        while (itr.hasNext()) {
                                            Lecturer beside = itr4.next();
                                            if (beside.id.equals(tempo4.id)) {
                                                frameUpdate.avatar.setText("this ID already exists!");
                                                decide1 = 2;
                                            }
                                        }
                                        if (decide1 == 3) {
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

                        Course basis = new Course("00000", "00007700234", 96);
                        ArrayList<Course> outPut2 = new ArrayList<Course>();
                        outPut2.add(basis);
                        TestSerializeCourse test33 = new TestSerializeCourse(outPut2);

                        int decide = 0;
                        TestDeserializeCourse Test11 = new TestDeserializeCourse();
                        ArrayList<Course> outPut1 = Test11.DeserializeCourse();
                        Iterator<Course> itr1 = outPut1.iterator();

                        while (itr1.hasNext()) {
                            Course beside1 = itr1.next();
                            if (beside1.code.equals(frameAdd.getCodeField())) {
                                decide++;
                                frameAdd.frame.add(frameAdd.avatar);
                                frameAdd.avatar.setText("This Code already exists");
                            }
                        }

                        if (decide == 0) {



                            outPut1.add(new Course(frameAdd.getNameField(), frameAdd.getCodeField(), frameAdd.getCreditField()));
                            TestSerializeCourse test = new TestSerializeCourse(outPut1);
                            frameAdd.setNameField("");
                            frameAdd.setCodeField("");
                            frameAdd.setCreditField(0);
                            frameAdd.frame.add(frameAdd.avatar);
                            frameAdd.avatar.setText("Done!");
                        }


                    }
                });
            }
        });
        courseDelete = new JMenuItem("Delete");
        courseDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFrameCourse frameDelete = new InforFrameCourse();
                frameDelete.setNameLabel("Name of Course:");
                frameDelete.setCodeLabel("Code of Course:");
                frameDelete.setCreditLabel("Number of Credits:");
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
                                frameDelete.setNameField(beside.name);
                                frameDelete.setCodeField(beside.code);
                                frameDelete.setCreditField(beside.credit);
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
        courseUpdate = new JMenuItem("Update");
        courseUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                final InforFrameCourse frameUpdate = new InforFrameCourse();
                frameUpdate.setNameLabel("Name of the course");
                frameUpdate.setCodeLabel("Code of the course");
                frameUpdate.setCreditLabel("Number of credits:");
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
                                frameUpdate.setNameField(beside.name);
                                frameUpdate.setCodeField(beside.code);
                                frameUpdate.setCreditField(beside.credit);
                                decide3 = 0;
                                frameUpdate.avatar.setVisible(false);
                                frameUpdate.update.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        if (decide3 == 0) {
                                            itr.remove();
                                        }
                                        decide3 = 3;

                                        Course tempo4 = new Course(frameUpdate.getNameField(), frameUpdate.getCodeField(), frameUpdate.getCreditField());

                                        TestDeserializeCourse Test4 = new TestDeserializeCourse();
                                        final ArrayList<Course> output = Test4.DeserializeCourse();
                                        final Iterator<Course> itr4 = output.iterator();
                                        while (itr.hasNext()) {
                                            Course beside = itr4.next();
                                            if (beside.code.equals(tempo4.code)) {
                                                frameUpdate.avatar.setText("this CODE already exists!");
                                                decide3 = 2;
                                            }
                                        }
                                        if (decide3 == 3) {
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
        dark = new JMenuItem("Dark");
        light= new JMenuItem("Light");
        system.add(dark);
        system.add(light);
        dark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setBackground(Color.DARK_GRAY);
            }
        });
        light.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setBackground(Color.WHITE);
            }
        });






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
        frame.setLocation(400,400);
        frame.setSize(500,200);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.add(menuBar,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }



}
