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
    //Desayunos
    private JLabel etiquetaTitulo,etiquetaOtto;
    private JButton campeCafe, botonSalir, tortasCastacan, panCazon;
    private JPanel panelMenu;
    private ImageIcon ottoLogo;
    public static void main(String[] args)
    {
        P4MunguiaAngelCam menu = new P4MunguiaAngelCam ();
        menu.setSize(1100,1100);
        menu.setTitle("La Fonda de Otto");
        menu.crearGUI();
        menu.setVisible(true);
    }
    private void crearGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        setLayout(null);
        //Panel Menú
        panelMenu=new JPanel()
        {   //Crear paintComponent para que se redibuje
            //protected es para que el método sea visible dentro de la clase
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);//Limpiar los paneles
                g.drawLine(50,54,850,54);
            }
        };
        panelMenu.setLayout(null);
        panelMenu.setBackground(new Color(255,184,92));
        panelMenu.setBounds(100,10,900,990);
        //Borde negro
        panelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        ventana.add(panelMenu);
        //Botón salir
        botonSalir=new JButton("Salir");
        botonSalir.setBounds(450,940,70,30);
        panelMenu.add(botonSalir);
        botonSalir.addActionListener(this);
        //Fuentes 
        Font fuenteTitulo=new Font("Inter",Font.BOLD,21);
        etiquetaTitulo=new JLabel("La Fonda de Otto");
        etiquetaTitulo.setFont(fuenteTitulo);
        etiquetaTitulo.setBounds(365,5,200,80);
        panelMenu.add(etiquetaTitulo);
        //Imagen Otomi
        ottoLogo=new ImageIcon(new ImageIcon("OttosLogo.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        Image otto=ottoLogo.getImage();
        JLabel etiquetaOtto=new JLabel();
        etiquetaOtto.setIcon(ottoLogo);
        etiquetaOtto.setBounds(412,72,100,100);
        panelMenu.add(etiquetaOtto);
    }
    public void actionPerformed(ActionEvent event)
    {
        Object botonSelec=event.getSource();
        if(botonSelec==botonSalir)
        {
            System.exit(0);
        }
    }
    
}

