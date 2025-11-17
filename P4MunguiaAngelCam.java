
/***
 * @Programa: P4MunguiaAngelCam.java
 * Autores: Munguía Reyes Ángel Gabriel y Gómez Cartagena Braulio
 * Fecha: 18/11/2025
 * Descripción:Programa que muestra un menú con platillos típicos de Campeche (Desayuno, comida y cena), con botones para pagar los productos y generar factuas.
 *  
 * ***/
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
  private JButton botonSalir;
  private JButton pedirCafe,quitarCafe,pedir1,quitar1,pedir2,quitar2,pedir3,quitar3, pedir4,quitar4,botonPagar;
  private JButton pedir5,quitar5,pedir6, quitar6, pedir7,quitar7,pedir8,quitar8,pedir9,quitar9,pedir10,quitar10,pedir11,quitar11;
  private JPanel panelMenu,panelPostres;
  private ImageIcon ottoLogo;

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
    // Panel Menú
    panelMenu = new JPanel()
    { // Crear paintComponent para que se redibuje
                               // protected es para que el método sea visible dentro de la clase
      protected void paintComponent(Graphics g) 
      {
        super.paintComponent(g);// Limpiar los paneles
        g.drawLine(50, 54, 850, 54);
      }
    };
    panelPostres=new JPanel()
    { // Crear paintComponent para que se redibuje
                               // protected es para que el método sea visible dentro de la clase
      protected void paintComponent(Graphics g) 
      {
        super.paintComponent(g);// Limpiar los paneles
        
      }
    };
    //PANELES
    //Principal
    panelMenu.setLayout(null);
    panelMenu.setBackground(new Color(255, 184, 92));
    panelMenu.setBounds(100, 10, 900, 990);
    //Postres
    panelPostres.setLayout(null);
    panelPostres.setBackground(new Color(251,184,92));
    panelPostres.setBounds(1035,10,850,500);
    
    // Borde negro
    panelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    ventana.add(panelMenu);
    panelPostres.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
    ventana.add(panelPostres);
    //BOTONES
    // Botón salir
    botonSalir = new JButton("Salir");
    botonSalir.setBounds(431, 940, 70, 30);
    panelMenu.add(botonSalir);
    botonSalir.addActionListener(this);
    //Botones pedir Desayuno
    pedirCafe=new JButton("Pedir");
    pedirCafe.setBounds(310,230,70,20);
    panelMenu.add(pedirCafe);
    pedirCafe.addActionListener(this);

    pedir1=new JButton("Pedir");
    pedir1.setBounds(310,350,70,20);
    panelMenu.add(pedir1);

    pedir2=new JButton("Pedir");
    pedir2.setBounds(310,470,70,20);
    panelMenu.add(pedir2);
    //Botones pedir Comida
    pedir3=new JButton("Pedir");
    pedir3.setBounds(750,230,70,20);
    panelMenu.add(pedir3);

    pedir4=new JButton("Pedir");
    pedir4.setBounds(750,350,70,20);
    panelMenu.add(pedir4);

    pedir5=new JButton("Pedir");
    pedir5.setBounds(750,470,70,20);
    panelMenu.add(pedir5);

    pedir6=new JButton("Pedir");
    pedir6.setBounds(220,740,70,20);
    panelMenu.add(pedir6);

    pedir7=new JButton("Pedir");
    pedir7.setBounds(510,740,70,20);
    panelMenu.add(pedir7);

    pedir8=new JButton("Pedir");
    pedir8.setBounds(760,740,70,20);
    panelMenu.add(pedir8);

    pedir9=new JButton("Pedir");
    pedir9.setBounds(210,220,70,20);
    panelPostres.add(pedir9);

    pedir10=new JButton("Pedir");
    pedir10.setBounds(478,220,70,20);
    panelPostres.add(pedir10);

    pedir11=new JButton("Pedir");
    pedir11.setBounds(760,220,70,20);
    panelPostres.add(pedir11);
    //Botones pagar
    botonPagar=new JButton("Pagar");
    botonPagar.setBounds(400,430,70,20);
    panelPostres.add(botonPagar);
    botonPagar.addActionListener(this);
    //ACOMODA LAS BOTONES CON EL NOMBRE DE LA COMIDA 
    
    //FUENTES 
    // Fuentes
    Font fuenteTitulo = new Font("Inter", Font.BOLD, 22);
    etiquetaTitulo = new JLabel("La Fonda de Otto");
    etiquetaTitulo.setFont(fuenteTitulo);
    etiquetaTitulo.setBounds(365, 5, 200, 30);
    panelMenu.add(etiquetaTitulo);
    //TÍTULOS
    //Desayunos
    Font fuenteTitutloDesayunos = new Font("Inter", Font.BOLD, 18);
    etiquetaDesayunos = new JLabel("Desayunos");
    etiquetaDesayunos.setFont(fuenteTitutloDesayunos);
    etiquetaDesayunos.setBounds(185, 140, 200, 80);
    panelMenu.add(etiquetaDesayunos);
    //Comidas
    Font fuenteTituloComidas = new Font("Inter",Font.BOLD,18);
    etiquetaComidas=new JLabel("Comidas");
    etiquetaComidas.setFont(fuenteTituloComidas);
    etiquetaComidas.setBounds(640,140,200,80);
    panelMenu.add(etiquetaComidas);
    //Cenas
    Font fuenteTituloCenas=new Font("Inter",Font.BOLD,18);
    etiquetaCena=new JLabel("Cenas");
    etiquetaCena.setFont(fuenteTituloCenas);
    etiquetaCena.setBounds(435,580,200,80);
    panelMenu.add(etiquetaCena);
    //Postres
    Font fuenteTituloPostres= new Font("Inter",Font.BOLD,18);
    etiquetaPostre=new JLabel("Postres");
    etiquetaPostre.setFont(fuenteTituloPostres);
    etiquetaPostre.setBounds(400,10,200,80);
    panelPostres.add(etiquetaPostre);
    //IMÁGENES
    // Imagen Otomi
    ottoLogo = new ImageIcon( new ImageIcon("Imagenes/OttosLogo.png").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    Image otto = ottoLogo.getImage();
    JLabel etiquetaOtto = new JLabel();
    etiquetaOtto.setIcon(ottoLogo);
    etiquetaOtto.setBounds(412, 68, 100, 100);
    panelMenu.add(etiquetaOtto);
  }

  public void actionPerformed(ActionEvent event) 
  {
    int cafe=0;
    Object botonSelec = event.getSource();
    if(botonSelec==pedirCafe)
    {
      cafe=cafe+1;
      
      
    }
    if(botonSelec==botonPagar)
    {
      PantallaPagar pagar= new PantallaPagar();
      pagar.setVisible(true);
    }
    if (botonSelec == botonSalir) 
    {
      System.exit(0);
    }
  }
  class PantallaPagar extends JFrame 
  {
    public PantallaPagar()
    {
      setTitle("Pagar");
      setSize(500,500);
      setLayout(null);

      JLabel etiqueta = new JLabel("Esta es la factura");
      etiqueta.setBounds(150, 50, 200, 30);
      add(etiqueta);

    }
  }
}


