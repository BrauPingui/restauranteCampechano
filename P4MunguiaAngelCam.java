
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
  private JTextField campoEfectivo,campoCambio,campoNumeroTarjeta,campoCantidad1,campoCantidad2,campoCVV,camporVigencia;
  private JTextField campoNumeroCuenta,campoNombre,campoDineroTarjeta,campoDineroTransferencia;
  private ImageIcon ottoLogo;
  private int cafe=0,primero=0,segundo=0,tercero=0,cuarto=0,quinto=0,sexto=0,septimo=0,octavo=0;
  private int noveno=0, decimo=0, onceavo=0;
  private double total;
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
    pedir1.addActionListener(this);

    pedir2=new JButton("Pedir");
    pedir2.setBounds(310,470,70,20);
    pedir2.addActionListener(this);
    panelMenu.add(pedir2);
    
    //Botones pedir Comida
    pedir3=new JButton("Pedir");
    pedir3.setBounds(750,230,70,20);
    pedir3.addActionListener(this);
    panelMenu.add(pedir3);

    pedir4=new JButton("Pedir");
    pedir4.setBounds(750,350,70,20);
    pedir4.addActionListener(this);
    panelMenu.add(pedir4);

    pedir5=new JButton("Pedir");
    pedir5.setBounds(750,470,70,20);
    pedir5.addActionListener(this);
    panelMenu.add(pedir5);

    pedir6=new JButton("Pedir");
    pedir6.setBounds(220,740,70,20);
    pedir6.addActionListener(this);
    panelMenu.add(pedir6);

    pedir7=new JButton("Pedir");
    pedir7.setBounds(510,740,70,20);
    pedir7.addActionListener(this);
    panelMenu.add(pedir7);

    pedir8=new JButton("Pedir");
    pedir8.setBounds(760,740,70,20);
    pedir8.addActionListener(this);
    panelMenu.add(pedir8);

    pedir9=new JButton("Pedir");
    pedir9.setBounds(210,220,70,20);
    pedir9.addActionListener(this);
    panelPostres.add(pedir9);

    pedir10=new JButton("Pedir");
    pedir10.setBounds(478,220,70,20);
    pedir10.addActionListener(this);
    panelPostres.add(pedir10);

    pedir11=new JButton("Pedir");
    pedir11.setBounds(760,220,70,20);
    pedir11.addActionListener(this);
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
    if(botonSelec==botonPagar)
    {
      cafe=cafe*80;
      primero=primero*100;
      segundo=segundo*80;
      tercero=tercero*70;
      cuarto=cuarto*130;
      quinto=quinto*130;
      sexto=sexto*170;
      septimo=septimo*120;
      octavo=octavo*180;
      noveno=noveno*80;
      decimo=decimo*80;
      onceavo=onceavo*180;
      total=cafe+primero+segundo+tercero+cuarto+quinto+sexto+septimo+octavo+noveno+decimo+onceavo;
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
    private JRadioButton rbCredito,rbDebito;
    private ButtonGroup grupoTarjeta;
    private JLabel etiquetaPagar,etiquetaCantidadTarjeta,etiquetaCantidadTransferencia, etiquetaEfectivo, etiquetaTarjeta,etiquetaTransferencia;
    private JLabel ingreseEfectivo,etiquetaNumeroTarjeta,etiquetaCVV,etiquetaVigencia, darCambio,etiquetaTotalPagar,etiquetaNumeroCuenta,etiquetaNombre;
    private JButton ingresarEfectivo,botonValidarTarjeta,botonValidarTransferencia;
    public PantallaPagar()
    {
      setTitle("Pagar");
      setSize(1000,700);
      setLayout(null);
      Font fuentePagar= new Font("Inter",Font.BOLD,18);
      etiquetaTotalPagar=new JLabel("Total a pagar:$"+total);
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
      //Efectivo y Cambio
      ingreseEfectivo=new JLabel("Ingrese efectivo");
      ingreseEfectivo.setFont(fuentePagar);
      ingreseEfectivo.setBounds(120,70,200,30);
      add(ingreseEfectivo);

      darCambio=new JLabel("Su cambio es:");
      darCambio.setFont(fuentePagar);
      darCambio.setBounds(120,260,200,30);
      add(darCambio);
      //Datos tarjeta
      rbCredito=new JRadioButton("Crédito");
      rbCredito.setBounds(400,120,200,20);
      rbCredito.setFont(fuentePagar);
      
      rbDebito=new JRadioButton("Débito");
      rbDebito.setBounds(490,120,200,20);
      rbDebito.setFont(fuentePagar);

      grupoTarjeta=new ButtonGroup();
      grupoTarjeta.add(rbCredito);
      grupoTarjeta.add(rbDebito);
      add(rbDebito);
      add(rbCredito);

      etiquetaNumeroTarjeta=new JLabel("No.Tarjeta, seguido");
      etiquetaNumeroTarjeta.setFont(fuentePagar);
      etiquetaNumeroTarjeta.setBounds(430,150,200,20);
      add(etiquetaNumeroTarjeta);

      etiquetaVigencia=new JLabel("Vigencia xx/xx");
      etiquetaVigencia.setFont(fuentePagar);
      etiquetaVigencia.setBounds(430,210,200,20);
      add(etiquetaVigencia);

      etiquetaCVV=new JLabel("Ingrese CVV");
      etiquetaCVV.setFont(fuentePagar);
      etiquetaCVV.setBounds(430,270,200,20);
      add(etiquetaCVV);

      etiquetaCantidadTarjeta=new JLabel("Ingrese cantidad");
      etiquetaCantidadTarjeta.setFont(fuentePagar);
      etiquetaCantidadTarjeta.setBounds(430,330,200,20);
      add(etiquetaCantidadTarjeta);
      //DATOS TRANSFERENCIA
      etiquetaNumeroCuenta=new JLabel("Ingrese No.Cuenta");
      etiquetaNumeroCuenta.setFont(fuentePagar);
      etiquetaNumeroCuenta.setBounds(770,80,200,30);
      add(etiquetaNumeroCuenta);

      etiquetaNombre=new JLabel("Ingresar Nombre");
      etiquetaNombre.setFont(fuentePagar);
      etiquetaNombre.setBounds(770,150,200,30);
      add(etiquetaNombre);

      etiquetaCantidadTransferencia=new JLabel("Ingresar Cantidad");
      etiquetaCantidadTransferencia.setFont(fuentePagar);
      etiquetaCantidadTransferencia.setBounds(770,210,200,30);
      add(etiquetaCantidadTransferencia);
      //Campo ingresar datos Transferencia
      campoDineroTransferencia=new JTextField(10);
      campoDineroTransferencia.setFont(fuentePagar);
      campoDineroTransferencia.setBounds(770,240,200,30);
      add(campoDineroTransferencia);

      campoNumeroCuenta=new JTextField(18);
      campoNumeroCuenta.setFont(fuentePagar);
      campoNumeroCuenta.setBounds(770,120,200,30);
      add(campoNumeroCuenta);

      campoNombre=new JTextField(20);
      campoNombre.setFont(fuentePagar);
      campoNombre.setBounds(770,180,200,30);
      add(campoNombre);
      //Campo ingresar datos tarjeta 
      campoNumeroTarjeta=new JTextField(16);
      campoNumeroTarjeta.setFont(fuentePagar);
      campoNumeroTarjeta.setBounds(430,170,200,30);
      add(campoNumeroTarjeta);
      
      camporVigencia=new JTextField(5);
      camporVigencia.setFont(fuentePagar);
      camporVigencia.setBounds(430,230,200,30);
      add(camporVigencia);

      campoCVV= new JTextField(3);
      campoCVV.setFont(fuentePagar);
      campoCVV.setBounds(430,300,200,30);
      add(campoCVV);

      campoDineroTarjeta= new JTextField(10);
      campoDineroTarjeta.setFont(fuentePagar);
      campoDineroTarjeta.setBounds(430,360,200,30);
      add(campoDineroTarjeta);
      //Ingresar y dar resultado 
      campoEfectivo=new JTextField(10);
      campoEfectivo.setBounds(120,100,150,30);
      campoEfectivo.setFont(fuentePagar);
      add(campoEfectivo);

      campoCambio=new JTextField(10);
      campoCambio.setBounds(120,300,150,30);
      campoCambio.setFont(fuentePagar);
      campoCambio.setEditable(false);
      campoCambio.setEnabled(false);
      add(campoCambio);
      //BOTONES
      botonValidarTransferencia=new JButton("Ingresar");
      botonValidarTransferencia.setBounds(770,270,200,30);
      botonValidarTransferencia.setFont(fuentePagar);
      add(botonValidarTransferencia);
      botonValidarTransferencia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          String numeroCuenta=campoNumeroCuenta.getText().trim();
          String nombre=campoNombre.getText().trim();
          String montoStrU=campoDineroTransferencia.getText().trim();
          if(!numeroCuenta.matches("\\d{18}"))
          {
            JOptionPane.showMessageDialog(null,"Número de cuenta inválido");
            return;
          }
          for(int i=0; i<nombre.length();i++)
          {
            char c=nombre.charAt(i);
            if(!((c>=65&&c<=90)||(c>=97&&c<=122)||c==32))
            {
              JOptionPane.showMessageDialog(null,"Nombre inválido");
              return;
            }
          }
          double monto;
          try
          {
            monto=Double.parseDouble(montoStrU);
            if(monto<=0)
            {
              JOptionPane.showMessageDialog(null,"Cantidad inválida");
              return;
            }
            if(monto<total)
            {
              JOptionPane.showMessageDialog(null,"Falta dinero");
              return;
            }
          }
          catch(NumberFormatException ex)
          {
            JOptionPane.showMessageDialog(null,"Valor inválido");
            return;
          }
          JOptionPane.showMessageDialog(null,"Transferencia exitosa");
          campoCambio.setText(String.format("%.2f",monto-total));
        }
      });

      botonValidarTarjeta= new JButton("Ingresar");
      botonValidarTarjeta.setFont(fuentePagar);
      botonValidarTarjeta.setBounds(430,400,200,30);
      add(botonValidarTarjeta);
      botonValidarTarjeta.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          String numeroTarjeta=campoNumeroTarjeta.getText().trim();
          String cvv=campoCVV.getText().trim();
          String vigencia=camporVigencia.getText().trim();
          String montoStr=campoDineroTarjeta.getText().trim();
          int mes=Integer.parseInt(vigencia.substring(0,2));
          int actual=2000+Integer.parseInt(vigencia.substring(3,5));
          if(!rbCredito.isSelected()&&!rbDebito.isSelected())
          {
            JOptionPane.showMessageDialog(null,"Seleccione tipo de tarjeta");
            return;
          }
          //Para validar estos campos se ocupa el método matches 
          //Indica cuantos digitos puede tener \\d{16} significa que acepta solamente 16 dígitos
          if(!numeroTarjeta.matches("\\d{16}"))
          {
            JOptionPane.showMessageDialog(null,"Numero de tarjeta invalido");
            return;
          }
          if(!cvv.matches("\\d{3}"))
          {
            JOptionPane.showMessageDialog(null,"CVV invalido, son 3 digitos");
            return;
          }
          if(!vigencia.matches("(0[1-9]|1[0-2]/\\d{2})")||mes<11&&actual<2025)
          {
            JOptionPane.showMessageDialog(null,"Vigencia invalida");
            return;
          }
          
            
          double monto;
          try
          {
            monto=Double.parseDouble(montoStr);
            if(monto<=0)
            {
              JOptionPane.showMessageDialog(null,"Ingrese una cantidad valida");
              return;
            }
            if(monto<total)
            {
              JOptionPane.showMessageDialog(null,"Falta dinero");
              return;
            }
          }
          catch(NumberFormatException ex)
          {
            JOptionPane.showMessageDialog(null,"Valor invalido");
            return;
          }
          JOptionPane.showMessageDialog(null,"Pago exitoso");
          campoCambio.setText(String.format("%.2f",monto-total));
        }
      });

      ingresarEfectivo= new JButton("Calcular");
      ingresarEfectivo.setFont(fuentePagar);
      ingresarEfectivo.setBounds(120,160,150,30);
      add(ingresarEfectivo);
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
            }
            else 
            {
              JOptionPane.showMessageDialog(null,"No es suficiente efectivo");
            }
          }
          catch(NumberFormatException ex)
          {
            JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
          }
        }
      });

    }
  }
}


