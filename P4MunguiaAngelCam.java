/*
 * Programa: P4MunguiaAngelCam.java
 * Autores: Munguía Reyes Ángel Gabriel y Gómez Cartagena Braulio
 * Fecha: 18/11/2025
 * Descripción:Programa que muestra un menú con platillos típicos de Campeche (Desayuno, comida y cena), con botones para pagar los productos y generar factuas.
 * * */
/*Bibliotecas*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Para agregar bordes 
import javax.swing.border.*;

public class P4MunguiaAngelCam extends JFrame implements ActionListener
{
  // Desayunos
  private JLabel etiquetaTitulo, etiquetaDesayunos,etiquetaComidas,etiquetaCena,etiquetaPostre;
  private JButton botonSalir,botonSalirPago;

  private JButton pedirCafe,quitarCafe,pedir1,quitar1,pedir2,quitar2,pedir3,quitar3, pedir4,quitar4,botonPagar;
  private JButton pedir5,quitar5,pedir6, quitar6, pedir7,quitar7,pedir8,quitar8,pedir9,quitar9,pedir10,quitar10,pedir11,quitar11;
  private JPanel panelMenu,panelPostres;
  // Campos de texto se declaran a nivel de instancia, aunque se inicializan en PantallaPagar
  private JTextField campoEfectivo,campoCambio,campoNumeroTarjeta,campoCantidad1,campoCantidad2,campoCVV,camporVigencia,campoRFC,campoNombreTarjeta;
  private JTextField campoNumeroCuenta,campoNombre,campoDineroTarjeta,campoDineroTransferencia;
  private ImageIcon ottoLogo;
  
  // Contadores de cantidad, NO de total monetario.
  private int cafe=0,primero=0,segundo=0,tercero=0,cuarto=0,quinto=0,sexto=0,septimo=0,octavo=0;
  private int noveno=0, decimo=0, onceavo=0;
  
  private double total;
  
  // Variables para guardar las cantidades al momento de pagar para el recibo (COPIAS)
  private int cantCafe, cantPrimero, cantSegundo, cantTercero, cantCuarto, cantQuinto;
  private int cantSexto, cantSeptimo, cantOctavo, cantNoveno, cantDecimo, cantOnceavo;

  public static void main(String[] args) 
  {
    P4MunguiaAngelCam menu = new P4MunguiaAngelCam();
    menu.setSize(2000, 1100);
    menu.setTitle("La Fonda de Otto");
    menu.crearGUI();
    menu.setVisible(true);
  }

  private void crearGUI() 
  {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container ventana = getContentPane();
    setLayout(null);

    panelMenu = new JPanel()
    {
      protected void paintComponent(Graphics g) 
      {
        super.paintComponent(g);
        // Dibujo de línea
        g.drawLine(50, 54, 850, 54); 
        g.setColor(new Color(180,140,80));  
        for (int i=0; i<getWidth(); i += 40)
        {
            g.fillRect(i, 0, 35, 25);        
            g.fillRect(i,getHeight()-30, 35, 25); // Bloques abajo
        }
        for (int j=0; j<getHeight(); j += 40) 
        {
            g.fillRect(0, j, 25, 35);        
            g.fillRect(getWidth() - 30, j, 25, 35); // Bloques derecha
        }
        g.setColor(new Color(0, 0, 0));
        g.drawLine(450, 200, 450, 530); // Desayuno/Comida
        g.drawLine(100, 550, 800, 550); // Comida/Cena
        g.drawLine(350, 680, 350, 880); // Cenas
        g.drawLine(600, 680, 600, 880); // Cenas
      }
    };

    panelPostres=new JPanel()
    {
      protected void paintComponent(Graphics g) 
      {
        super.paintComponent(g);
        g.setColor(new Color(180, 140, 80));  

        
        for (int i=0; i<getWidth(); i+=40) 
        {
            g.fillRect(i, 0, 35, 25);                  
            g.fillRect(i, getHeight() - 30, 35, 25);   
        }

        // Bloques laterales
        for (int j=0; j<getHeight(); j+=40) 
        {
            g.fillRect(0, j, 25, 35);                  
            g.fillRect(getWidth() - 30, j, 25, 35);    
        }
        g.setColor(new Color(0, 0, 0));
        g.drawLine(330, 100, 330, 400); // Postres
        g.drawLine(600, 100, 600, 400); // Postres
      }
    };

    panelMenu.setLayout(null);
    panelMenu.setBackground(new Color(255, 184, 92));
    panelMenu.setBounds(100, 10, 900, 990);

    panelPostres.setLayout(null);
    panelPostres.setBackground(new Color(251,184,92));
    panelPostres.setBounds(1035,10,850,500);
    
    panelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    ventana.add(panelMenu);
    panelPostres.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
    ventana.add(panelPostres);

    botonSalir = new JButton("Salir");
    botonSalir.setBounds(431, 920, 70, 30);
    panelMenu.add(botonSalir);
    botonSalir.addActionListener(this);

  
    
    int anchoImagen = 150;
    int altoImagen = 80;
    
   
    // Café
    pedirCafe=new JButton("Pedir");
    pedirCafe.setBounds(310,230,70,20);
    panelMenu.add(pedirCafe);
    pedirCafe.addActionListener(this);

    quitarCafe=new JButton("Quitar");
    quitarCafe.setBounds(310,260,80,20);
    panelMenu.add(quitarCafe);
    quitarCafe.addActionListener(this);

    // IMAGEN CAFÉ
    JLabel imgCafe = new JLabel();
    ImageIcon iconCafe = new ImageIcon(new ImageIcon("./cafe-de-olla-campechanas.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgCafe.setIcon(iconCafe);
    imgCafe.setBounds(100, 225, anchoImagen, altoImagen);
    panelMenu.add(imgCafe);
    
    // Pan de Cazón
    pedir1=new JButton("Pedir");
    pedir1.setBounds(310,350,70,20);
    panelMenu.add(pedir1);
    pedir1.addActionListener(this);

    quitar1=new JButton("Quitar");
    quitar1.setBounds(310,380,80,20);
    panelMenu.add(quitar1);
    quitar1.addActionListener(this);

    // IMAGEN PAN DE CAZÓN
    JLabel imgPanCazon = new JLabel();
    ImageIcon iconPanCazon = new ImageIcon(new ImageIcon("./PanDeCazon.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgPanCazon.setIcon(iconPanCazon);
    imgPanCazon.setBounds(100, 320, anchoImagen, altoImagen);
    panelMenu.add(imgPanCazon);

    // TamalChaya
    pedir2=new JButton("Pedir");
    pedir2.setBounds(310,470,70,20);
    pedir2.addActionListener(this);
    panelMenu.add(pedir2);

    quitar2=new JButton("Quitar");
    quitar2.setBounds(310,500,80,20);
    panelMenu.add(quitar2);
    quitar2.addActionListener(this);

    // IMAGEN TAMAL CHAYA
    JLabel imgtamalchaya = new JLabel();
    ImageIcon icontamalchaya = new ImageIcon(new ImageIcon("./tamalchaya.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgtamalchaya.setIcon(icontamalchaya);
    imgtamalchaya.setBounds(100, 420, anchoImagen, altoImagen);
    panelMenu.add(imgtamalchaya);

    // Cochinita Pibil
    pedir3=new JButton("Pedir");
    pedir3.setBounds(750,230,70,20);
    pedir3.addActionListener(this);
    panelMenu.add(pedir3);
    
    quitar3=new JButton("Quitar");
    quitar3.setBounds(750,260,80,20);
    panelMenu.add(quitar3);
    quitar3.addActionListener(this);

    // IMAGEN COCHINITA
    JLabel imgCochinita = new JLabel();
    ImageIcon iconCochinita = new ImageIcon(new ImageIcon("./CochinitaPibil.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgCochinita.setIcon(iconCochinita);
    imgCochinita.setBounds(540, 200, anchoImagen, altoImagen);
    panelMenu.add(imgCochinita);

    // Tacos Campechanos
    pedir4=new JButton("Pedir");
    pedir4.setBounds(750,350,70,20);
    pedir4.addActionListener(this);
    panelMenu.add(pedir4);

    quitar4=new JButton("Quitar");
    quitar4.setBounds(750,380,80,20);
    panelMenu.add(quitar4);
    quitar4.addActionListener(this);

    // IMAGEN TACOS CAMPECHANOS
    JLabel imgTcampechano = new JLabel();
    ImageIcon iconTcampechano = new ImageIcon(new ImageIcon("./maxresdefault.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgTcampechano.setIcon(iconTcampechano);
    imgTcampechano.setBounds(540, 330, anchoImagen, altoImagen);
    panelMenu.add(imgTcampechano);

    // Mariscada
    pedir5=new JButton("Pedir");
    pedir5.setBounds(750,470,70,20);
    pedir5.addActionListener(this);
    panelMenu.add(pedir5);

    quitar5=new JButton("Quitar");
    quitar5.setBounds(750,500,80,20);
    panelMenu.add(quitar5);
    quitar5.addActionListener(this);

    // IMAGEN JAMON CLAVETEADO
    JLabel imgJamonC = new JLabel();
    ImageIcon iconJamonC = new ImageIcon(new ImageIcon("./torta-de-jamon-claveteado.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgJamonC.setIcon(iconJamonC);
    imgJamonC.setBounds(540, 450, anchoImagen, altoImagen);
    panelMenu.add(imgJamonC);

    

    // PAMPANO EMPAPELADO
    pedir6=new JButton("Pedir");
    pedir6.setBounds(85,730,70,20);
    pedir6.addActionListener(this);
    panelMenu.add(pedir6);

    quitar6=new JButton("Quitar");
    quitar6.setBounds(240,730,80,20);
    quitar6.addActionListener(this);
    panelMenu.add(quitar6);

    // IMAGEN PAMPANO EMPAPELADO
    JLabel imgPampanoE = new JLabel();
    ImageIcon iconPampanoE = new ImageIcon(new ImageIcon("./pampano-empapelado.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgPampanoE.setIcon(iconPampanoE);
    imgPampanoE.setBounds(115, 780, anchoImagen, altoImagen);
    panelMenu.add(imgPampanoE);

    // Tortas
    pedir7=new JButton("Pedir");
    pedir7.setBounds(390,730,70,20);
    pedir7.addActionListener(this);
    panelMenu.add(pedir7);
    
    quitar7=new JButton("Quitar");
    quitar7.setBounds(510,730,80,20);
    quitar7.addActionListener(this);
    panelMenu.add(quitar7);

    // IMAGEN TORTAS 
    JLabel imgTortas = new JLabel();
    ImageIcon iconTortas = new ImageIcon(new ImageIcon("./torta.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgTortas.setIcon(iconTortas);
    imgTortas.setBounds(405, 780, anchoImagen, altoImagen);
    panelMenu.add(imgTortas);

    // CAMARONES AL COCO
    pedir8=new JButton("Pedir");
    pedir8.setBounds(650,730,70,20);
    pedir8.addActionListener(this);
    panelMenu.add(pedir8);

    quitar8=new JButton("Quitar");
    quitar8.setBounds(780,730,80,20);
    quitar8.addActionListener(this);
    panelMenu.add(quitar8);

    // IMAGEN CAMARONES AL COCO
    JLabel imgCamaronesC = new JLabel();
    ImageIcon iconCamaronesC = new ImageIcon(new ImageIcon("./camarones-al-coco.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgCamaronesC.setIcon(iconCamaronesC);
    imgCamaronesC.setBounds(650, 780, anchoImagen, altoImagen);
    panelMenu.add(imgCamaronesC);

    // Fraile
    pedir9=new JButton("Pedir");
    pedir9.setBounds(191,220,70,20);
    pedir9.addActionListener(this);
    panelPostres.add(pedir9);

    quitar9=new JButton("Quitar");
    quitar9.setBounds(102,220,80,20);
    quitar9.addActionListener(this);
    panelPostres.add(quitar9);

    // IMAGEN Fraile
    JLabel imgFraile = new JLabel();
    ImageIcon iconFraile = new ImageIcon(new ImageIcon("./sddefault.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgFraile.setIcon(iconFraile);
    imgFraile.setBounds(100, 250, anchoImagen, altoImagen);
    panelPostres.add(imgFraile);

    // Flan Rompope
    pedir10=new JButton("Pedir");
    pedir10.setBounds(478,220,70,20);
    pedir10.addActionListener(this);
    panelPostres.add(pedir10);

    quitar10=new JButton("Quitar");
    quitar10.setBounds(378,220,80,20);
    quitar10.addActionListener(this);
    panelPostres.add(quitar10);
    
    // IMAGEN FLAN ROMPOPE
    JLabel imgFlan = new JLabel();
    ImageIcon iconFlan = new ImageIcon(new ImageIcon("./FlanRompope.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgFlan.setIcon(iconFlan);
    imgFlan.setBounds(390, 250, anchoImagen, altoImagen);
    panelPostres.add(imgFlan);

    // Jamoncillos
    pedir11=new JButton("Pedir");
    pedir11.setBounds(730,220,70,20);
    pedir11.addActionListener(this);
    panelPostres.add(pedir11);

    quitar11=new JButton("Quitar");
    quitar11.setBounds(620,220,80,20);
    quitar11.addActionListener(this);
    panelPostres.add(quitar11);
    // IMAGEN JAMONCILLOS
    JLabel imgJamonci = new JLabel();
    ImageIcon iconJamonci = new ImageIcon(new ImageIcon("./jamoncillo-dulce-mexicano.jpg").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
    imgJamonci.setIcon(iconJamonci);
    imgJamonci.setBounds(630, 250, anchoImagen, altoImagen);
    panelPostres.add(imgJamonci);
    
    // Botón Pagar 
    botonPagar=new JButton("Pagar");
    botonPagar.setBounds(400,430,70,20);
    panelPostres.add(botonPagar);
    botonPagar.addActionListener(this);

 
    Font fuenteTitulo = new Font("Inter", Font.BOLD, 22);
    etiquetaTitulo = new JLabel("La Fonda de Otto");
    etiquetaTitulo.setFont(fuenteTitulo);
    etiquetaTitulo.setBounds(365, 20, 200, 30);
    panelMenu.add(etiquetaTitulo);

    Font fuenteTitutloDesayunos = new Font("Inter", Font.BOLD, 18);
    etiquetaDesayunos = new JLabel("Desayunos");
    etiquetaDesayunos.setFont(fuenteTitutloDesayunos);
    etiquetaDesayunos.setBounds(185, 140, 200, 80);
    panelMenu.add(etiquetaDesayunos);

    Font fuenteTituloComidas = new Font("Inter",Font.BOLD,18);
    etiquetaComidas=new JLabel("Comidas");
    etiquetaComidas.setFont(fuenteTituloComidas);
    etiquetaComidas.setBounds(640,140,200,80);
    panelMenu.add(etiquetaComidas);

    Font fuenteTituloCenas=new Font("Inter",Font.BOLD,18);
    etiquetaCena=new JLabel("Cenas");
    etiquetaCena.setFont(fuenteTituloCenas);
    etiquetaCena.setBounds(435,580,200,80);
    panelMenu.add(etiquetaCena);

    Font fuenteTituloPostres= new Font("Inter",Font.BOLD,18);
    etiquetaPostre=new JLabel("Postres");
    etiquetaPostre.setFont(fuenteTituloPostres);
    etiquetaPostre.setBounds(400,10,200,80);
    panelPostres.add(etiquetaPostre);

    // LOGO
    ottoLogo = new ImageIcon( new ImageIcon("OttosLogo.png").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    JLabel etiquetaOtto = new JLabel();
    etiquetaOtto.setIcon(ottoLogo);
    etiquetaOtto.setBounds(412, 68, 100, 100);
    panelMenu.add(etiquetaOtto);
    JPanel panelHorario = new JPanel();
    panelHorario.setLayout(new BoxLayout(panelHorario, BoxLayout.Y_AXIS)); 
    panelHorario.setBackground(new Color(255, 200, 120)); 
    
    panelHorario.setBounds(1035, 520, 850, 400); 
    
    // Título del Marco
    panelHorario.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.BLACK, 2), // Borde negro más grueso
        "Atención al Cliente",
        TitledBorder.CENTER, // Centrar el título
        TitledBorder.TOP,
        new Font("Inter", Font.BOLD, 20) // Fuente más grande para el título del marco
    ));
    
    ventana.add(panelHorario);

    // Fuentes más grandes
    Font fuenteHorarioTitulo = new Font("Inter", Font.BOLD, 48); // Título de la etiqueta
    Font fuenteHorarioTexto = new Font("Inter", Font.PLAIN, 36); // Texto de los horarios

    // Etiqueta Título
    JLabel lblHorarioTitulo = new JLabel("Horarios de Atención:");
    lblHorarioTitulo.setFont(fuenteHorarioTitulo);
    lblHorarioTitulo.setAlignmentX(Component.CENTER_ALIGNMENT); 
    panelHorario.add(Box.createVerticalStrut(15)); // Espacio superior
    panelHorario.add(lblHorarioTitulo);
    panelHorario.add(Box.createVerticalStrut(10)); // Separación

    // Etiqueta Días
    JLabel lblHorarioDias = new JLabel("Lunes a Sábado:");
    lblHorarioDias.setFont(fuenteHorarioTexto);
    lblHorarioDias.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelHorario.add(lblHorarioDias);
    
    // Etiqueta Horas
    JLabel lblHorarioHoras = new JLabel("12:00 pm - 12:00 am");
    lblHorarioHoras.setFont(fuenteHorarioTexto);
    lblHorarioHoras.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelHorario.add(lblHorarioHoras);

    // Etiqueta telefono
    JLabel lblTelefono = new JLabel ("NÚMERO DE ATENCIÓN");
    lblTelefono.setFont(fuenteHorarioTitulo);
    lblTelefono.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelHorario.add(lblTelefono);

    JLabel lblTelefonoN = new JLabel ("951-345-2932");
    lblTelefonoN.setFont(fuenteHorarioTexto);
    lblTelefonoN.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelHorario.add(lblTelefonoN);
    
    Font fuenteMenu = new Font("Inter", Font.PLAIN, 20);

    // Desayunos
    JLabel lblCafe = new JLabel("Campechanas - $80");
    lblCafe.setBounds(240, 205, 250, 20); 
    lblCafe.setFont(fuenteMenu);
    panelMenu.add(lblCafe);

    JLabel lblDesayuno1 = new JLabel("Pan de Cazón - $100");
    lblDesayuno1.setBounds(270, 330, 250, 20); 
    lblDesayuno1.setFont(fuenteMenu);
    panelMenu.add(lblDesayuno1);

    JLabel lblDesayuno2 = new JLabel("TamalChaya - $80");
    lblDesayuno2.setBounds(270, 450, 250, 20); 
    lblDesayuno2.setFont(fuenteMenu);
    panelMenu.add(lblDesayuno2);
    
    // Comidas
    JLabel lblComida1 = new JLabel("Cochinita Pibil - $70");
    lblComida1.setBounds(700, 210, 250, 20); 
    lblComida1.setFont(fuenteMenu);
    panelMenu.add(lblComida1);

    JLabel lblComida2 = new JLabel("Tacos Campech - $130");
    lblComida2.setBounds(640, 310, 250, 20); 
    lblComida2.setFont(fuenteMenu);
    panelMenu.add(lblComida2);

    JLabel lblComida3 = new JLabel("Torta BeefSteak - $130");
    lblComida3.setBounds(630, 410, 250, 20); 
    lblComida3.setFont(fuenteMenu);
    panelMenu.add(lblComida3);
    
    // Cenas
    JLabel lblCena1 = new JLabel("Pampano Empap - $170");
    lblCena1.setBounds(100, 680, 250, 20);
    lblCena1.setFont(fuenteMenu);
    panelMenu.add(lblCena1);

    JLabel lblCena2 = new JLabel("Jamon CLaveteado - $120");
    lblCena2.setBounds(362, 680, 250, 20); 
    lblCena2.setFont(fuenteMenu);
    panelMenu.add(lblCena2);

    JLabel lblCena3 = new JLabel("Camarones al Coco - $180");
    lblCena3.setBounds(635, 680, 250, 20); 
    lblCena3.setFont(fuenteMenu);
    panelMenu.add(lblCena3);

    // Postres
    JLabel lblPostre1 = new JLabel("Fraile - $80");
    lblPostre1.setBounds(120, 200, 200, 20); 
    lblPostre1.setFont(fuenteMenu);
    panelPostres.add(lblPostre1);

    JLabel lblPostre2 = new JLabel("Flan Rompope - $80");
    lblPostre2.setBounds(390, 200, 200, 20);
    lblPostre2.setFont(fuenteMenu);
    panelPostres.add(lblPostre2);

    JLabel lblPostre3 = new JLabel("Jamoncillo - $180");
    lblPostre3.setBounds(650, 200, 200, 20);
    lblPostre3.setFont(fuenteMenu);
    panelPostres.add(lblPostre3);
    
  }

  public void actionPerformed(ActionEvent event) 
  {
    Object botonSelec = event.getSource();
    if(botonSelec==pedirCafe)
      cafe=cafe+1;
    if(botonSelec==pedir1)
      primero=primero+1;
    if(botonSelec==pedir2)
      segundo=segundo+1;
    if(botonSelec==pedir3)
      tercero=tercero+1;
    if(botonSelec==pedir4)
      cuarto=cuarto+1;
    if(botonSelec==pedir5)
      quinto=quinto+1;
    if(botonSelec==pedir6)
      sexto=sexto+1;
    if(botonSelec==pedir7)
      septimo=septimo+1;
    if(botonSelec==pedir8)
      octavo=octavo+1;
    if(botonSelec==pedir9)
      noveno=noveno+1;
    if(botonSelec==pedir10)
      decimo=decimo+1;
    if(botonSelec==pedir11)
      onceavo=onceavo+1;
    if(botonSelec==quitarCafe&&cafe!=0)
      cafe--;
    if(botonSelec==quitar1&&primero!=0)
      primero--;
    if(botonSelec==quitar2&&segundo!=0)
      segundo--;
    if(botonSelec==quitar3&&tercero!=0)
      tercero--;
    if(botonSelec==quitar4&&cuarto!=0)
      cuarto--;
    if(botonSelec==quitar5&&quinto!=0)
      quinto--;
    if(botonSelec==quitar6&&sexto!=0)
      sexto--;
    if(botonSelec==quitar7&&septimo!=0)
      septimo--;
    if(botonSelec==quitar8&&octavo!=0)
      octavo--;
    if(botonSelec==quitar9&&noveno!=0)
      noveno--;
    if(botonSelec==quitar10&&decimo!=0)
      decimo--;
    if(botonSelec==quitar11&&onceavo!=0)
      onceavo--;
    if(botonSelec==botonPagar)
    {
      
      cantCafe = cafe;
      cantPrimero = primero;
      cantSegundo = segundo;
      cantTercero = tercero;
      cantCuarto = cuarto;
      cantQuinto = quinto;
      cantSexto = sexto;
      cantSeptimo = septimo;
      cantOctavo = octavo;
      cantNoveno = noveno;
      cantDecimo = decimo;
      cantOnceavo = onceavo;

      // Calcular el total usando los precios
      double totalCafe = cafe * 80;
      double totalPrimero = primero * 100;
      double totalSegundo = segundo * 80;
      double totalTercero = tercero * 70;
      double totalCuarto = cuarto * 130;
      double totalQuinto = quinto * 130;
      double totalSexto = sexto * 170;
      double totalSeptimo = septimo * 120;
      double totalOctavo = octavo * 180;
      double totalNoveno = noveno * 80;
      double totalDecimo = decimo * 80;
      double totalOnceavo = onceavo * 180;
      
      // Sumar el total
      total=totalCafe+totalPrimero+totalSegundo+totalTercero+totalCuarto+totalQuinto+totalSexto+totalSeptimo+totalOctavo+totalNoveno+totalDecimo+totalOnceavo;
      
      // Mostrar pantalla de pago
      PantallaPagar pagar= new PantallaPagar();
      pagar.setVisible(true);
    }

    if (botonSelec == botonSalir) 
    {
      System.exit(0);
    }
  }

  // Clase anidada para la pantalla de pago
  class PantallaPagar extends JFrame 
  {
    private JRadioButton rbCredito,rbDebito;
    private ButtonGroup grupoTarjeta;
    private JLabel etiquetaPagar,etiquetaCantidadTarjeta,etiquetaCantidadTransferencia, etiquetaEfectivo, etiquetaTarjeta,etiquetaTransferencia,etiquetaRFC;
    private JLabel ingreseEfectivo,etiquetaNumeroTarjeta,etiquetaCVV,etiquetaVigencia, darCambio,etiquetaTotalPagar,etiquetaNumeroCuenta,etiquetaNombre,etiquetaNombreTarjeta;
    private JButton ingresarEfectivo,botonValidarTarjeta,botonValidarTransferencia;

    public PantallaPagar()
    {
      setTitle("Pagar");
      setSize(1000,700);
      setLayout(null);
      
      // Inicializar campos de texto para la pantalla de pago
      campoEfectivo = new JTextField(10);
      campoCambio = new JTextField(10);
      campoNumeroTarjeta = new JTextField(16);
      camporVigencia = new JTextField(5);
      campoCVV = new JTextField(3);
      campoDineroTarjeta = new JTextField(10);
      campoNumeroCuenta = new JTextField(18);
      campoNombre = new JTextField(20);
      campoDineroTransferencia = new JTextField(10);
      campoNombreTarjeta=new JTextField(10);
      
      Font fuentePagar= new Font("Inter",Font.BOLD,18);

      etiquetaTotalPagar=new JLabel("Total a pagar:$"+String.format("%.2f", total)); // Formatear el total
      etiquetaTotalPagar.setBounds(680,10,200,30);
      etiquetaTotalPagar.setFont(fuentePagar);
      add(etiquetaTotalPagar);

      etiquetaPagar= new JLabel("PAGAR");
      etiquetaPagar.setFont(fuentePagar);
      etiquetaPagar.setBounds(500,10,80,20);
      add(etiquetaPagar);

      etiquetaEfectivo=new JLabel("EFECTIVO");
      etiquetaEfectivo.setFont(fuentePagar);
      etiquetaEfectivo.setBounds(120,50,100,20);
      add(etiquetaEfectivo);

      etiquetaTarjeta=new JLabel("TARJETA");
      etiquetaTarjeta.setFont(fuentePagar);
      etiquetaTarjeta.setBounds(430,50,100,20);
      add(etiquetaTarjeta);

      etiquetaTransferencia= new JLabel("TRANSFERENCIA");
      etiquetaTransferencia.setFont(fuentePagar);
      etiquetaTransferencia.setBounds(770,50,200,20);
      add(etiquetaTransferencia);

      ingreseEfectivo=new JLabel("Ingrese efectivo");
      ingreseEfectivo.setFont(fuentePagar);
      ingreseEfectivo.setBounds(120,70,200,30);
      add(ingreseEfectivo);

      darCambio=new JLabel("Su cambio es:");
      darCambio.setFont(fuentePagar);
      darCambio.setBounds(120,260,200,30);
      add(darCambio);

      etiquetaNombreTarjeta=new JLabel("Ingrese nombre");
      etiquetaNombreTarjeta.setFont(fuentePagar);
      etiquetaNombreTarjeta.setBounds(430,80,200,20);
      add(etiquetaNombreTarjeta);

      rbCredito=new JRadioButton("Crédito");
      rbCredito.setBounds(400,140,200,20); 
      rbCredito.setFont(fuentePagar);
      
      rbDebito=new JRadioButton("Débito");
      rbDebito.setBounds(500,140,200,20); 
      rbDebito.setFont(fuentePagar);

      grupoTarjeta=new ButtonGroup();
      grupoTarjeta.add(rbCredito);
      grupoTarjeta.add(rbDebito);
      add(rbDebito);
      add(rbCredito);

      etiquetaNumeroTarjeta=new JLabel("No.Tarjeta");
      etiquetaNumeroTarjeta.setFont(fuentePagar);
      etiquetaNumeroTarjeta.setBounds(430,180,200,20);
      add(etiquetaNumeroTarjeta);

      etiquetaVigencia=new JLabel("Vigencia (MM/AA)");
      etiquetaVigencia.setFont(fuentePagar);
      etiquetaVigencia.setBounds(430,240,200,20);
      add(etiquetaVigencia);


      etiquetaCVV=new JLabel("Ingrese CVV");
      etiquetaCVV.setFont(fuentePagar);
      etiquetaCVV.setBounds(430,290,200,20);
      add(etiquetaCVV);

      etiquetaCantidadTarjeta=new JLabel("Cantidad");
      etiquetaCantidadTarjeta.setFont(fuentePagar);
      etiquetaCantidadTarjeta.setBounds(430,337,200,20);
      add(etiquetaCantidadTarjeta);

      etiquetaNumeroCuenta=new JLabel("Ingrese No.Cuenta");
      etiquetaNumeroCuenta.setFont(fuentePagar);
      etiquetaNumeroCuenta.setBounds(770,80,200,30);
      add(etiquetaNumeroCuenta);

      etiquetaNombre=new JLabel("Ingresar Nombre");
      etiquetaNombre.setFont(fuentePagar);
      etiquetaNombre.setBounds(770,150,200,30);
      add(etiquetaNombre);

      etiquetaCantidadTransferencia=new JLabel("Cantidad");
      etiquetaCantidadTransferencia.setFont(fuentePagar);
      etiquetaCantidadTransferencia.setBounds(770,210,200,30);
      add(etiquetaCantidadTransferencia);

      etiquetaRFC=new JLabel("Ingrese su RFC");
      etiquetaRFC.setFont(fuentePagar);
      etiquetaRFC.setBounds(770,270,200,30);
      add(etiquetaRFC);

      campoDineroTransferencia.setFont(fuentePagar);
      campoDineroTransferencia.setBounds(770,240,200,30);
      campoDineroTransferencia.setEditable(false);
      campoDineroTransferencia.setEnabled(true);
      campoDineroTransferencia.setText(String.format("%.2f", total));
      add(campoDineroTransferencia);

      campoNumeroCuenta.setFont(fuentePagar);
      campoNumeroCuenta.setBounds(770,120,200,30);
      add(campoNumeroCuenta);

      campoNombre.setFont(fuentePagar);
      campoNombre.setBounds(770,180,200,30);
      add(campoNombre);

      campoNumeroTarjeta.setFont(fuentePagar);
      campoNumeroTarjeta.setBounds(430,210,200,30);
      add(campoNumeroTarjeta);
      
      camporVigencia.setFont(fuentePagar);
      camporVigencia.setBounds(430,260,200,30);
      add(camporVigencia);

      campoCVV.setFont(fuentePagar);
      campoCVV.setBounds(430,310,200,30);
      add(campoCVV);

      campoDineroTarjeta.setFont(fuentePagar);
      campoDineroTarjeta.setBounds(430,360,200,30);
      campoDineroTarjeta.setEditable(false);
      campoDineroTarjeta.setEnabled(true);
      campoDineroTarjeta.setText(String.format("$%.2f",total));
      add(campoDineroTarjeta);

      campoRFC=new JTextField(13);
      campoRFC.setBounds(770,300,200,30);
      campoRFC.setFont(fuentePagar);
      add(campoRFC);

      campoEfectivo.setBounds(120,100,150,30);
      campoEfectivo.setFont(fuentePagar);
      add(campoEfectivo);

      campoCambio.setBounds(120,300,150,30);
      campoCambio.setFont(fuentePagar);
      campoCambio.setEditable(false);
      campoCambio.setEnabled(true); 
      add(campoCambio);

      campoNombreTarjeta=new JTextField(14);
      campoNombreTarjeta.setBounds(430,110,200,30);
      campoNombreTarjeta.setFont(fuentePagar);
      add(campoNombreTarjeta);

      botonValidarTransferencia=new JButton("Ingresar");
      botonValidarTransferencia.setBounds(770,340,200,30);
      botonValidarTransferencia.setFont(fuentePagar);
      add(botonValidarTransferencia);

      botonSalirPago= new JButton("Salir");
      botonSalirPago.setBounds(770,500,200,30);
      botonSalirPago.setFont(fuentePagar);
      add(botonSalirPago);
      botonSalirPago.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          total=0.0;
          cafe=0;
          primero=0;
          segundo=0;
          tercero=0;
          cuarto=0;
          quinto=0;
          sexto=0;
          septimo=0;
          octavo=0;
          noveno=0;
          decimo=0;
          onceavo=0;
          dispose();
        }
      });
      // Listener para transferencia
      botonValidarTransferencia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          String numeroCuenta=campoNumeroCuenta.getText().trim();
          String nombre=campoNombre.getText().trim();
          String montoStrU=campoDineroTransferencia.getText().trim();
          String rfc=campoRFC.getText().trim();
          if(!numeroCuenta.matches("\\d{18}"))
          {
            JOptionPane.showMessageDialog(null,"Número de cuenta inválido (debe tener 18 dígitos).");
            return;
          }
          // Lógica de validación de nombre
          for(int i=0; i<nombre.length();i++)
          {
            char c=nombre.charAt(i);
            if(!((c>='A'&&c<='Z')||(c>='a'&&c<='z')||c==' '))
            {
              JOptionPane.showMessageDialog(null,"Nombre inválido (solo letras y espacios sin acentos).");
              return;
            }
          }
          if(!rfc.matches("[A-Za-z0-9]{13}"))
          {
            JOptionPane.showMessageDialog(null,"RFC inválido");
            return;
          }
          double monto=total;
          
          try
          {
              monto=Double.parseDouble(montoStrU);
              if(monto < total)
              {
                JOptionPane.showMessageDialog(null,"El monto transferido no cubre el total a pagar.");
                return;
              }
          }
          catch(NumberFormatException ex)
          {
            JOptionPane.showMessageDialog(null,"Valor inválido en el monto.");
            return;
          }
          JOptionPane.showMessageDialog(null,"Transferencia exitosa");
          

          // *** ABRIR RECIBO ***
          // Se pasan los 12 contadores de cantidad
          new PantallaRecibo(total, monto, monto-total,
            cantCafe, cantPrimero, cantSegundo, cantTercero, cantCuarto,
            cantQuinto, cantSexto, cantSeptimo, cantOctavo,
            cantNoveno, cantDecimo, cantOnceavo).setVisible(true);
        }
      });

      botonValidarTarjeta= new JButton("Ingresar");
      botonValidarTarjeta.setFont(fuentePagar);
      botonValidarTarjeta.setBounds(430,400,200,30);
      add(botonValidarTarjeta);
      
      // Listener para tarjeta
      botonValidarTarjeta.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          String numeroTarjeta=campoNumeroTarjeta.getText().trim();
          String cvv=campoCVV.getText().trim();
          String vigencia=camporVigencia.getText().trim();
          String montoStr=campoDineroTarjeta.getText().trim();
          String nombreTarjeta=campoNombreTarjeta.getText().trim();
          for(int i=0; i<nombreTarjeta.length();i++)
          {
            char c=nombreTarjeta.charAt(i);
            if(!((c>='A'&&c<='Z')||(c>='a'&&c<='z')||c==' '))
            {
              JOptionPane.showMessageDialog(null,"Nombre inválido (solo letras y espacios sin acentos).");
              return;
            }
          }
          if(!rbCredito.isSelected()&&!rbDebito.isSelected())
          {
            JOptionPane.showMessageDialog(null,"Seleccione tipo de tarjeta (Crédito/Débito).");
            return;
          }
          if(!numeroTarjeta.matches("\\d{16}"))
          {
            JOptionPane.showMessageDialog(null,"Número de tarjeta inválido (debe tener 16 dígitos).");
            return;
          }
          if(!cvv.matches("\\d{3}"))
          {
            JOptionPane.showMessageDialog(null,"CVV inválido, son 3 dígitos.");
            return;
          }
          
          if(!vigencia.matches("(0[1-9]|1[0-2])/[0-9]{2}"))
          {
            JOptionPane.showMessageDialog(null,"Formato de vigencia inválido (MM/AA).");
            return;
          }
          
          // Validar vigencia
          int mes=Integer.parseInt(vigencia.substring(0,2));
          int anioVigencia=2000+Integer.parseInt(vigencia.substring(3,5));
          java.util.Calendar cal = java.util.Calendar.getInstance();
          int mesActual = cal.get(java.util.Calendar.MONTH) + 1; // Enero es 0
          int anioActual = cal.get(java.util.Calendar.YEAR);
          
          if(anioVigencia < anioActual || (anioVigencia == anioActual && mes < mesActual))
          {
              JOptionPane.showMessageDialog(null,"Tarjeta expirada o vigencia inválida.");
              return;
          }

          double monto=total;
          

          JOptionPane.showMessageDialog(null,"Pago exitoso");
         

          // *** ABRIR RECIBO ***
          // Se pasan los 12 contadores de cantidad
          new PantallaRecibo(total, monto, monto-total,
            cantCafe, cantPrimero, cantSegundo, cantTercero, cantCuarto,
            cantQuinto, cantSexto, cantSeptimo, cantOctavo,
            cantNoveno, cantDecimo, cantOnceavo).setVisible(true);
        }
      });

      ingresarEfectivo= new JButton("Calcular");
      ingresarEfectivo.setFont(fuentePagar);
      ingresarEfectivo.setBounds(120,160,150,30);
      add(ingresarEfectivo);
      
      // Listener para efectivo
      ingresarEfectivo.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          try
          {
            double pagoUsuario=Double.parseDouble(campoEfectivo.getText());
            double cambio=pagoUsuario-total;
            if(cambio>=0)
            {
              campoCambio.setText(String.format("%.2f",cambio));

              // *** ABRIR RECIBO ***
              // Se pasan los 12 contadores de cantidad
              new PantallaRecibo(total, pagoUsuario, cambio,
                cantCafe, cantPrimero, cantSegundo, cantTercero, cantCuarto,
                cantQuinto, cantSexto, cantSeptimo, cantOctavo,
                cantNoveno, cantDecimo, cantOnceavo).setVisible(true);
            }
            else 
            {
              JOptionPane.showMessageDialog(null,"No es suficiente efectivo. Faltan: $"+String.format("%.2f", -cambio));
            }
          }
          catch(NumberFormatException ex)
          {
            JOptionPane.showMessageDialog(null,"Ingrese un valor válido en efectivo.");
          }
        }
      });
    }
  } // FIN PANTALLA PAGAR


//RECIBO
class PantallaRecibo extends JFrame 
{
    
    // Se ajusta la firma para aceptar 12 ints (c1 a c12)
    public PantallaRecibo(double total, double pago, double cambio, 
                          int c1,int c2,int c3,int c4,int c5,int c6,
                          int c7,int c8,int c9,int c10,int c11, int c12) 
    { 

        setTitle("Recibo - Fonda de Otto");
        setSize(500,600);
        setLayout(null);

        JTextArea texto = new JTextArea();
        Font fuenteRecibo = new Font("Monospaced", Font.PLAIN, 16); // Tamaño 16
        texto.setFont(fuenteRecibo);
        texto.setEditable(false);
        JScrollPane scroll = new JScrollPane(texto);
        scroll.setBounds(20,20,450,480);
        add(scroll);

        JButton guardar = new JButton("Guardar recibo");
        guardar.setBounds(150,510,180,40);
        add(guardar);

        StringBuilder recibo = new StringBuilder();
        recibo.append("        *** FONDA DE OTTO ***\n");
        recibo.append("  Recibo generado: " + java.time.LocalDateTime.now() + "\n");
        recibo.append("------------------------------------\n");
        
        if(!campoNombre.getText().trim().isEmpty())
        {
          recibo.append("Nombre del usuario:"+campoNombre.getText().trim()+"\n");
        }
        if (!campoRFC.getText().trim().isEmpty())
        {
          recibo.append("RFC del usuario: "+campoRFC.getText().trim()+"\n");
        }
        if(!campoNombreTarjeta.getText().trim().isEmpty())
          recibo.append("Nombre del usuario:"+campoNombreTarjeta.getText().trim()+"\n");
        recibo.append("Productos:\n");
        // Se usa c1 a c12 para imprimir las cantidades y precios
        if(c1>0) recibo.append(String.format("Café x%d  $%.2f + $%.2f IVA\n", c1, (double)(c1*80)-((c1*80)*0.16),(c1*80)*0.16));
        if(c2>0) recibo.append(String.format("Pan de Cazón x%d  $%.2f + $%.2f IVA\n", c2, (double)(c2*100)-((c2*100)*0.16),(c2*100)*0.16 ));
        if(c3>0) recibo.append(String.format("Tamal de Chaya x%d  $%.2f + $%.2f IVA\n", c3, (double)(c3*80)-((c3*80)*0.16),(c3*80)*0.16 ));//80
        if(c4>0) recibo.append(String.format("Cochinita Pibil x%d  $%.2f + $%.2f IVA\n", c4, (double)(c4*70)-((c4*70)*0.16),(c4*70)*0.16));//70
        if(c5>0) recibo.append(String.format("Tacos Campechanos x%d  $%.2f + $%.2f IVA\n", c5, (double)(c5*130)-((c5*130)*0.16),(c5*130)*0.16));//130
        if(c6>0) recibo.append(String.format("Torta BeefSteak x%d  $%.2f + $%.2f IVA\n", c6, (double)(c6*130)-((c6*130)*0.16),(c6*130)*0.16 ));//130
        if(c7>0) recibo.append(String.format("Pampano Empapelado x%d  $%.2f + $%.2f IVA\n", c7, (double)(c7*170)-((c7*170)*0.16),(c7*170)*0.16 ));//170
        if(c8>0) recibo.append(String.format("Tortas de Jamon Claveteado x%d  $%.2f + $%.2f IVA\n", c8, (double)(c8*120)-((c8*120)*0.16),(c8*120)*0.16 ));//120
        if(c9>0) recibo.append(String.format("Camarones al Coco x%d  $%.2f + $%.2f IVA\n", c9, (double)(c9*180)-((c9*180)*0.16),(c9*180)*0.16 ));//180
        if(c10>0) recibo.append(String.format("Frailes x%d  $%.2f + $%.2f IVA\n", c10, (double)(c10*80)-((c10*80)*0.16),(c10*80)*0.16 ));//80
        if(c11>0) recibo.append(String.format("Flan de Rompope x%d $%.2f + $%.2f IVA\n", c11, (double)(c11*80)-((c11*80)*0.16),(c11*80)*0.16 ));//80
        if(c12>0) recibo.append(String.format("Jamoncillos x%d $%.2f + $%.2f IVA\n", c12, (double)(c12*180)-((c12*180)*0.16),(c12*180)*0.16 ));//180

        recibo.append("------------------------------------\n");
        recibo.append(String.format("TOTAL: $%.2f\n", total));
        recibo.append(String.format("PAGO:  $%.2f\n", pago));
        recibo.append(String.format("CAMBIO: $%.2f\n", cambio));
        recibo.append("------------------------------------\n");
        recibo.append("¡Gracias por su compra!\n");
        String codigo = "|| | || ||| | |||| | | || ||| |";
        String numeroCodigo = "123456789012";

        recibo.append("\nCódigo de barras:\n");
        recibo.append(codigo + "\n");
        recibo.append(numeroCodigo + "\n");
        

        texto.setText(recibo.toString());


        guardar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    // Se utiliza la librería java.io para escribir en un archivo
                    java.io.FileWriter fw = new java.io.FileWriter("recibo_otto.txt");
                    fw.write(recibo.toString());
                    fw.close();
                    JOptionPane.showMessageDialog(null,"Recibo guardado como recibo_otto.txt");
                } 
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Error al guardar el archivo: " + ex.getMessage());
                }
            }
        });
    }
}

}