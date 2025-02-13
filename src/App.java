import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//parear string a int Integer.parseInt()

public class App {
    public static void main(String[] args) {

        Maquina maquina1 = new Maquina(10);

         System.out.println(maquina1.getGlecheA());
         System.out.println(maquina1.getgCafeA());
         System.out.println(maquina1.getgCacacoA());
         System.out.println(maquina1.getMlAgua());
         System.out.println(maquina1.getVasosNum());
        System.out.println("///////////////////////////");

        // bucle para que el menu se repita hasta que se requiera lo contrario

        int mostrarOpciones = 0;

        while (mostrarOpciones != 3) {

            String[] options = { "Pedir Cafe", "Crear Cafe", "Recargar Maquina", "salir/exit" };
            String[] llenarOption = { "Llenar cafe(g)", "Llenar leche(g)", "Llenar cacao(g)", "Llenar agua(ml)",
                    "Llenar vasos(num)" };
                    
            mostrarOpciones = JOptionPane.showOptionDialog(null, "Que desea a continuacion",
                    "click a button please ",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (mostrarOpciones) {
                case 0:

                    if (maquina1.tieneVasos()) {
                        System.out.println("OPT 1: pedir cafe/");
                        int opcionCafe = Integer.parseInt(JOptionPane
                                .showInputDialog(maquina1.MostrarCafes() + "digite el numero de cafe deseado (1,2 etc):"));
                        if (opcionCafe >= 1 && opcionCafe <= maquina1.getCafesArray().size()) {// aqui se controla que
                                                                                               // no coloquen opciones
                                                                                               // invalidas
                            Cafe cafeSeleccionado = maquina1.getCafesArray().get(opcionCafe - 1);
                            maquina1.prepararCafe(cafeSeleccionado);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Opción inválida. Por favor, seleccione un café válido.");
                        }
                    }
                    break;

                case 1:
                    System.out.println("OPT 2: crear cafe/");
                    maquina1.crearCafe();
                    break;

                case 2:
                    System.out.println("OPT 3: rellenar maquina/");
                    int q = JOptionPane.showOptionDialog(null, "Que deseas rellenar",
                            "seleccione un cuadro",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, llenarOption,
                            llenarOption[0]);

                    switch (q) {
                        case 0:
                            System.out.println("quest 2: /opcion 1  cafe");
                            maquina1.rellenarCafe();
                            break;
                        case 1:
                            System.out.println("quest 2: /opcion 2  leche ");
                            maquina1.rellenarLeche();
                            break;
                        case 2:
                            System.out.println("quest 2:/ opcion 3  cacao");
                            maquina1.rellenarCacao();
                            break;
                        case 3:
                            System.out.println("quest 2: /opcion 4  agua");
                            maquina1.rellenarAgua();
                            break;
                        case 4:
                            System.out.println("quest 2: /opcion 5  vasos");
                            maquina1.rellenarVasos();
                            break;

                    }
                break;

                case 3:
                    System.out.println("OPT 4: Exit");
                    JOptionPane.showMessageDialog(null, "Un placer buen dia y vuelva pronto .");

                default:
                    break;
            }

        }
    }
    //
}// fin de app.java