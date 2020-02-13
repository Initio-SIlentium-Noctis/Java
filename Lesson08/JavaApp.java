package Lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import static javax.swing.JOptionPane.*;
import javax.swing.Timer;

public class JavaApp {

    static Poll myWindow = new Poll(); // создаём экземпляр объекта Poll
    static String name;
    static String capchaField;
    static javax.swing.JLabel logo;
    static javax.swing.JLabel gif;
    static javax.swing.JLabel capcha;

    static class Poll extends JFrame implements ActionListener {
        public Poll()  {
            setTitle("Самый честный опрос сотрудников");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(600, 300, 600, 400);
            setLayout(null); // устанавливаем, чтобы кнопки и другие элементы можно было размещать по координатам
            setResizable(false); // невозможность менять размер окна
            logo = new javax.swing.JLabel();
            logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/img01.png")));
            gif = new javax.swing.JLabel();
            gif.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/shredding.gif")));
            capcha = new javax.swing.JLabel();
            capcha.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/img02.png")));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static void Page1 ()  {
        logo.setPreferredSize(new Dimension(400, 300));
        logo.setBounds(100,1,400,300);
        JButton button = new JButton("Далее");
        button.setPreferredSize(new Dimension(100, 50));
        button.setBounds(250,300,100,50);
        myWindow.add(logo);
        myWindow.add(button);
        myWindow.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Container myWindow = button.getParent();
                    myWindow.removeAll(); // убрать все элементы перед переходом на следующую страницу
                    myWindow.revalidate();
                    myWindow.repaint(); // метод необходим для перерисовки окна после удаления элементов
                    Page2(); // переход на следующую страницу
                }
        });
    }

    public static void Page2 () {
        JButton button = new JButton("Далее");
        button.setPreferredSize(new Dimension(100, 50));
        button.setBounds(250,300,100,50);
        JLabel label = new JLabel("<html><body><font size=6> Приветствуем Вас, </font><s>не </s><font size=6>уважаемый сотрудник !</font></body></html>");
        label.setPreferredSize(new Dimension(600, 50));
        label.setBounds(25,1,600,50);
        JLabel label1 = new JLabel("<html><body><font size=4> С целью повышения мотивации и качества работы ООО «Самая честная компания» проводит самый честный опрос среди своих сотрудников. В ходе прохождения опроса вам будет предложено ответить на несколько вопросов. Просьба отнестись к вопросам со всей серьёзностью и отвечать честно, так как в конце опроса все данные будут отправлены на анализ в наш внутренний департамент. Мы гарантируем вам, что опрос полностью конфиденциален, а собранная статистика будет проанализирована и все просьбы и предложения сотрудников будут приняты на рассмотрение.</font></body></html>");
        label1.setPreferredSize(new Dimension(570, 200));
        label1.setBounds(10,45,570,200);
        JLabel label2 = new JLabel("<html><body><font size=5> С уважением, HR департамент</font></body></html>");
        label2.setPreferredSize(new Dimension(570, 100));
        label2.setBounds(270,220,570,100);
        myWindow.add(button);
        myWindow.add(label);
        myWindow.add(label1);
        myWindow.add(label2);
        myWindow.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container myWindow = button.getParent();
                myWindow.removeAll();
                myWindow.revalidate();
                myWindow.repaint();
                Page3();
            }
        });
    }


    public static void Page3 ()  {
        JButton button1 = new JButton("Начать");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JLabel label1 = new JLabel("<html><body><font size=5> Перед прохождением опроса, пожалуйста введите ваше имя :</font></body></html>");
        label1.setPreferredSize(new Dimension(300, 200));
        label1.setBounds(200,50,300,200);
        JLabel label2 = new JLabel("<html><body><font color='red'>необходимо указать ваше имя</font></body></html>");
        label2.setPreferredSize(new Dimension(300, 200));
        label2.setBounds(200,150,200,100);
        JLabel label3= new JLabel("<html><body><font color='red'>недопустимый символ</font></body></html>");
        label3.setPreferredSize(new Dimension(300, 200));
        label3.setBounds(200,150,200,100);
        JTextField field1= new JTextField();
        field1.setBounds(250, 220, 100, 25);
        myWindow.add(button1);
        myWindow.add(label1);
        myWindow.add(label2);
        myWindow.add(label3);
        myWindow.add(field1);
        label2.setVisible(false);
        label3.setVisible(false);
        field1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                name = field1.getText();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name == null) {
                    label2.setVisible(true);
                } else if (!name.matches("\\S+")) {
                    label2.setVisible(false);
                    label3.setVisible(true);
                } else {
                Container myWindow = button1.getParent();
                myWindow.removeAll();
                myWindow.revalidate();
                myWindow.repaint();
                Page4();
            }}
        });
        myWindow.setVisible(true);
    }

    public static void Page4()  {
        JButton button1 = new JButton("Ответить");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JLabel label1 = new JLabel("<html><body><font size=5>Почему вы решили работать именно в нашей компании ?</font></body></html>");
        label1.setPreferredSize(new Dimension(500, 50));
        label1.setBounds(100,10,500,50);
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton ("<html><body><font size=4>Я рассылал резюме всем. Кто первый пригласил на собеседование - к тем и пошёл.</font></body></html>");
        radio1.setMnemonic(KeyEvent.VK_B);
        radio1.setSelected(false);
        radio1.setPreferredSize(new Dimension(490, 50));
        radio1.setBounds(50,75,490,50);
        JRadioButton radio2 = new JRadioButton ("<html><body><font size=4>Привлекло громкое название компании</font></body></html>");
        radio2.setMnemonic(KeyEvent.VK_B);
        radio2.setSelected(false);
        radio2.setPreferredSize(new Dimension(490, 50));
        radio2.setBounds(50,125,490,50);
        JRadioButton radio3 = new JRadioButton ("<html><body><font size=4>Я думал, что здесь меня ждёт карьерный рост</font></body></html>");
        radio3.setMnemonic(KeyEvent.VK_B);
        radio3.setSelected(false);
        radio3.setPreferredSize(new Dimension(490, 50));
        radio3.setBounds(50,175,490,50);
        JRadioButton radio4 = new JRadioButton ("<html><body><font size=4>Понравилась возможность выпить вместе с начальником раз в год на корпоративе</font></body></html>");
        radio4.setMnemonic(KeyEvent.VK_B);
        radio4.setSelected(false);
        radio4.setPreferredSize(new Dimension(400, 75));
        radio4.setBounds(50,225,400,75);
        buttons.add(radio1);
        buttons.add(radio2);
        buttons.add(radio3);
        buttons.add(radio4);
        myWindow.add(button1);
        myWindow.add(label1);
        myWindow.add(radio1);
        myWindow.add(radio2);
        myWindow.add(radio3);
        myWindow.add(radio4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page5();
                } else if (radio2.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page5();
                } else if (radio3.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page5();
                } else if (radio4.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page5();
                } else JOptionPane.showMessageDialog(null, "Не выбран ни один вариант ответа !", "Ошибка", ERROR_MESSAGE);
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page5()  {
        JButton button1 = new JButton("Ответить");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JLabel label1 = new JLabel("<html><body><font size=5>Что вас больше всего не устраивает в настоящее время в нашей компании ?</font></body></html>");
        label1.setPreferredSize(new Dimension(500, 50));
        label1.setBounds(100,10,500,50);
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton ("<html><body><font size=4>Не налажен рабочий процесс</font></body></html>");
        radio1.setMnemonic(KeyEvent.VK_B);
        radio1.setSelected(false);
        radio1.setPreferredSize(new Dimension(490, 50));
        radio1.setBounds(50,75,490,50);
        JRadioButton radio2 = new JRadioButton ("<html><body><font size=4></font>«Дружный коллектив»</body></html>");
        radio2.setMnemonic(KeyEvent.VK_B);
        radio2.setSelected(false);
        radio2.setPreferredSize(new Dimension(490, 50));
        radio2.setBounds(50,125,490,50);
        JRadioButton radio3 = new JRadioButton ("<html><body><font size=4>Задержка выплат на несколько месяцев</font></body></html>");
        radio3.setMnemonic(KeyEvent.VK_B);
        radio3.setSelected(false);
        radio3.setPreferredSize(new Dimension(490, 50));
        radio3.setBounds(50,175,490,50);
        JRadioButton radio4 = new JRadioButton ("<html><body><font size=4>Беспредел руководства</font></body></html>");
        radio4.setMnemonic(KeyEvent.VK_B);
        radio4.setSelected(false);
        radio4.setPreferredSize(new Dimension(400, 75));
        radio4.setBounds(50,225,400,75);
        buttons.add(radio1);
        buttons.add(radio2);
        buttons.add(radio3);
        buttons.add(radio4);
        myWindow.add(button1);
        myWindow.add(label1);
        myWindow.add(radio1);
        myWindow.add(radio2);
        myWindow.add(radio3);
        myWindow.add(radio4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page6();
                } else if (radio2.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page6();
                } else if (radio3.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page6();
                } else if (radio4.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page6();
                } else JOptionPane.showMessageDialog(null, "Не выбран ни один вариант ответа !", "Ошибка", ERROR_MESSAGE);
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page6()  {
        JButton button1 = new JButton("Ответить");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JLabel label1 = new JLabel("<html><body><font size=5>Что вам больше всего хотелось бы получить от компании в ближайшее время ?</font></body></html>");
        label1.setPreferredSize(new Dimension(500, 50));
        label1.setBounds(100,10,500,50);
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton ("<html><body><font size=4>Заслуженный законный отпуск 2 недели по ТК</font></body></html>");
        radio1.setMnemonic(KeyEvent.VK_B);
        radio1.setSelected(false);
        radio1.setPreferredSize(new Dimension(490, 50));
        radio1.setBounds(50,75,490,50);
        JRadioButton radio2 = new JRadioButton ("<html><body><font size=4></font>Зарплату за последние 3 месяца</body></html>");
        radio2.setMnemonic(KeyEvent.VK_B);
        radio2.setSelected(false);
        radio2.setPreferredSize(new Dimension(490, 50));
        radio2.setBounds(50,125,490,50);
        JRadioButton radio3 = new JRadioButton ("<html><body><font size=4></font>Чистое рабочее место</body></html>");
        radio3.setMnemonic(KeyEvent.VK_B);
        radio3.setSelected(false);
        radio3.setPreferredSize(new Dimension(490, 50));
        radio3.setBounds(50,175,490,50);
        JRadioButton radio4 = new JRadioButton ("<html><body><font size=4></font>Адекватное отношение к сотрудникам</body></html>");
        radio4.setMnemonic(KeyEvent.VK_B);
        radio4.setSelected(false);
        radio4.setPreferredSize(new Dimension(400, 75));
        radio4.setBounds(50,225,400,75);
        buttons.add(radio1);
        buttons.add(radio2);
        buttons.add(radio3);
        buttons.add(radio4);
        myWindow.add(button1);
        myWindow.add(label1);
        myWindow.add(radio1);
        myWindow.add(radio2);
        myWindow.add(radio3);
        myWindow.add(radio4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page7();
                } else if (radio2.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page7();
                } else if (radio3.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page7();
                } else if (radio4.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page7();
                } else JOptionPane.showMessageDialog(null, "Не выбран ни один вариант ответа !", "Ошибка", ERROR_MESSAGE);
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page7 ()  {
        JLabel label1 = new JLabel("<html><body><font size=5>Довольны ли вы вашей зарплатой ?</font></body></html>");
        label1.setPreferredSize(new Dimension(500, 50));
        label1.setBounds(130,10,500,50);
        JButton button1 = new JButton("Нет");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(350,300,100,50);
        JButton button2 = new JButton("Да");
        button2.setPreferredSize(new Dimension(100, 50));
        button2.setBounds(150,300,100,50);
        myWindow.add(label1);
        myWindow.add(button1);
        myWindow.add(button2);
        button1.addMouseListener(new MouseAdapter() {
            /* В статистике компании  не нужны недовольные зарплатой сотрудники, поэтому кнопка "Нет"
            всегда будет уезжать от пользователя при наведении мышью */
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1.setLocation(new Random().nextInt(550), new Random().nextInt(350));
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container myWindow = button2.getParent();
                myWindow.removeAll();
                myWindow.revalidate();
                myWindow.repaint();
                Page8();
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page8()  {
        JButton button1 = new JButton("Ответить");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JLabel label1 = new JLabel("<html><body><font size=5>Довольны ли вы действиями руководства вашего отдела ?</font></body></html>");
        label1.setPreferredSize(new Dimension(500, 50));
        label1.setBounds(100,10,500,50);
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton ("<html><body><font size=4>Не доволен</font></body></html>");
        radio1.setMnemonic(KeyEvent.VK_B);
        radio1.setSelected(false);
        radio1.setPreferredSize(new Dimension(490, 50));
        radio1.setBounds(50,75,490,50);
        JRadioButton radio2 = new JRadioButton ("<html><body><font size=4></font>Совершенно не доволен</body></html>");
        radio2.setMnemonic(KeyEvent.VK_B);
        radio2.setSelected(false);
        radio2.setPreferredSize(new Dimension(490, 50));
        radio2.setBounds(50,125,490,50);
        JRadioButton radio3 = new JRadioButton ("<html><body><font size=4></font>Категорически не доволен</body></html>");
        radio3.setMnemonic(KeyEvent.VK_B);
        radio3.setSelected(false);
        radio3.setPreferredSize(new Dimension(490, 50));
        radio3.setBounds(50,175,490,50);
        JRadioButton radio4 = new JRadioButton ("<html><body><font size=4></font>Менять надо такое «руководство»</body></html>");
        radio4.setMnemonic(KeyEvent.VK_B);
        radio4.setSelected(false);
        radio4.setPreferredSize(new Dimension(400, 75));
        radio4.setBounds(50,225,400,75);
        buttons.add(radio1);
        buttons.add(radio2);
        buttons.add(radio3);
        buttons.add(radio4);
        myWindow.add(button1);
        myWindow.add(label1);
        myWindow.add(radio1);
        myWindow.add(radio2);
        myWindow.add(radio3);
        myWindow.add(radio4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page9();
                } else if (radio2.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page9();
                } else if (radio3.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page9();
                } else if (radio4.isSelected()) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                    Page9();
                } else JOptionPane.showMessageDialog(null, "Не выбран ни один вариант ответа !", "Ошибка", ERROR_MESSAGE);
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page9()  {
        JButton button1 = new JButton("Отправить");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JLabel label1 = new JLabel("<html><body><font size=5>Благодарим вас за прохождение опроса !</font></body></html>");
        label1.setPreferredSize(new Dimension(500, 50));
        label1.setBounds(100,10,500,50);
        JLabel label2 = new JLabel("<html><body><font size=4>Пожалуйста, нажмите на кнопку ниже чтобы отправить по факсу результаты вашего опроса на наш сервер !</font></body></html>");
        label2.setPreferredSize(new Dimension(570, 200));
        label2.setBounds(10,45,570,200);
        myWindow.add(button1);
        myWindow.add(label1);
        myWindow.add(label2);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container myWindow = button1.getParent();
                myWindow.removeAll();
                myWindow.revalidate();
                myWindow.repaint();
                Page10();
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page10()  {
        JLabel label1 = new JLabel("<html><body><font size=4>Идёт подключение к серверу ...</font></body></html>");
        label1.setPreferredSize(new Dimension(200, 100));
        label1.setBounds(350,80,200,100);
        JLabel label2 = new JLabel("<html><body><font size=4>Связь установлена ! Передача факса ...</font></body></html>");
        label2.setPreferredSize(new Dimension(200, 100));
        label2.setBounds(350,80,200,100);
        gif.setPreferredSize(new Dimension(337, 389));
        gif.setBounds(1,1,337,389);
        myWindow.add(gif);
        myWindow.add(label1);
        myWindow.add(label2);
        myWindow.setVisible(true);
        label1.setVisible(true);
        label2.setVisible(false);
        Timer t = new Timer(5000, myWindow); // создание таймеров для имитации отправки данных
        Timer t2 = new Timer(4000, myWindow);
        t.setRepeats(false);
        t2.setRepeats(false);
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(true);
                t2.start();
            }
        });
        t.start();

        t2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myWindow.remove(gif);
                myWindow.remove(label1);
                myWindow.remove(label2);
                myWindow.revalidate();
                myWindow.repaint();
                Page11();
            }
        });
    }

    public static void Page11() {
        JButton button1 = new JButton("Далее");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(250,300,100,50);
        JTextField field1= new JTextField();
        field1.setBounds(200, 275, 200, 25);
        JLabel label1 = new JLabel("<html><body><font size=4>ВНИМАНИЕ ! С вашего ip адреса регистрируется много частых попыток подключения. Подтвердите, что вы не робот ! Введите <u>первые 14 символов</u> того, что видите на изображении снизу :</font></body></html>");
        label1.setPreferredSize(new Dimension(590, 70));
        label1.setBounds(1,1,590,70);
        JLabel label2 = new JLabel("<html><body><font color='red'>неправильный ввод !</font></body></html>");
        label2.setPreferredSize(new Dimension(150, 25));
        label2.setBounds(420,275,150,25);
        capcha.setPreferredSize(new Dimension(500, 200));
        capcha.setBounds(50,70,500,200);
        myWindow.add(capcha);
        myWindow.add(label1);
        myWindow.add(label2);
        label2.setVisible(false);
        myWindow.add(button1);
        myWindow.add(field1);
        myWindow.revalidate();
        myWindow.repaint();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capchaField = field1.getText();
                if (capchaField.equals("Я покорный раб")) {
                    Container myWindow = button1.getParent();
                    myWindow.removeAll();
                    myWindow.revalidate();
                    myWindow.repaint();
                        Page12();
                } else {
                    label2.setVisible(true);
                }
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page12()  {
        JButton button1 = new JButton("Далее");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBounds(350,300,100,50);
        JLabel label3 = new JLabel("<html><body><font size=4>Данные успешно переданы ! Мы вам это <u>гарантируем </u>!</body></html>");
        label3.setPreferredSize(new Dimension(200, 100));
        label3.setBounds(350,80,200,100);
        gif.setPreferredSize(new Dimension(337, 389));
        gif.setBounds(1,1,337,389);
        myWindow.add(gif);
        myWindow.add(label3);
        myWindow.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container myWindow = button1.getParent();
                myWindow.removeAll();
                myWindow.revalidate();
                myWindow.repaint();
                Page13();
            }
        });
        myWindow.setVisible(true);
    }

    public static void Page13() {
        JButton button = new JButton("Завершить");
        button.setPreferredSize(new Dimension(100, 50));
        button.setBounds(250, 300, 100, 50);
        JLabel label1 = new JLabel("<html><body><font size=4>Благодарим вас за прохождение опроса ! Данный опрос и ваше мнение очень важны для нас. Спасибо, что помогаете нам становиться лучше. Ждите изменений !</font></body></html>");
        label1.setPreferredSize(new Dimension(570, 200));
        label1.setBounds(10,45,570,200);
        myWindow.add(button);
        myWindow.add(label1);
        myWindow.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container myWindow = button.getParent();
                myWindow.removeAll();
                myWindow.revalidate();
                myWindow.repaint();
                System.exit(0); // завершение работы приложения
            }
        });
    }

    public static void main(String[] args)  {
        Page1(); // переход на первую странциу опроса
    }
}






