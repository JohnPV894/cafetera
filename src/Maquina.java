import java.util.*;

import javax.swing.JOptionPane;

public class Maquina {

    // atributos
    private double numeroSerie;
    private ArrayList<Cafe> cafesArray; // cafesArray = new ArrayList<>();
    private int vasosNum;
    private int gCafeA;
    private int glecheA;
    private int gCacacoA;
    private int mlAgua;

    // constructor
    public Maquina(int vasosNum) {
        numeroSerie = Math.floor(Math.random() * (1000 - 9999) + 9999);
        this.vasosNum = vasosNum;
        this.gCafeA = 0;
        this.glecheA = 0;
        this.gCacacoA = 0;
        this.mlAgua = 0;
        this.cafesArray = Metodocafes();
    }

    public ArrayList<Cafe> Metodocafes() {
        ArrayList<Cafe> cafesArray = new ArrayList<>();
        cafesArray.add(new Cafe("Cafe debil", 15, 15, 15));
        cafesArray.add(new Cafe("Cafe fuerte", 40, 40, 40));
        return cafesArray;
    }

    // metodo recuperar nombres y posicion

    public String MostrarCafes() {//convierte el arraylist en una lista numerada de cafes 
        StringBuilder info = new StringBuilder();

        for (int i = 0; i < cafesArray.size(); i++) {
            String nameCafes = cafesArray.get(i).getNombre();
            // System.out.println((i+1)+" "+nameCafes);
            info.append((i + 1)).append(". ").append(nameCafes).append("\n");
        }
        return info.toString();
    }

    // crea agregar y verificar el cafe
    public String crearCafe() {
        String newNombre = JOptionPane.showInputDialog("Escribe el nombre que desea colocarle");
        int newCafe = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de gramos de cafe"));
        int newLeche = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de gramos de leche"));
        int newCacao = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de gramos de cacao"));
        cafesArray.add(new Cafe(newNombre, newCafe, newLeche, newCacao));
        JOptionPane.showMessageDialog(null, "el cafe con nombre " + newNombre + " se creo y agrego correctamente");
        return "nice";
    }

    // metodo confirmar requisito vasos
    public boolean tieneVasos() {// requisito vasos
        if (vasosNum > 0) {
            return true;
        } else {
            return false;
        }
    }// comprueba materiales

    public boolean tieneMaterialSuficiente(Cafe cafe) {
        int totalAgua = cafe.getgCafe() + cafe.getgLeche() + cafe.getgCacaco();
        return totalAgua <= mlAgua && gCafeA >= cafe.getgCafe() && glecheA >= cafe.getgLeche()
                && gCacacoA >= cafe.getgCacaco();
    }

    // preparar
    public void prepararCafe(Cafe cafe) {
        if (tieneMaterialSuficiente(cafe) && tieneVasos()) {
             mlAgua -= cafe.getgCafe() + cafe.getgLeche() + cafe.getgCacaco();
             gCafeA -= cafe.getgCafe();
             glecheA -= cafe.getgLeche();
             gCacacoA -= cafe.getgCacaco();
             vasosNum--;
            JOptionPane.showMessageDialog(null, "Café " + cafe.getNombre() + " preparado. ¡Disfrútelo!");
        } else {
            JOptionPane.showMessageDialog(null, "Lo siento, no hay material suficiente o vasos .");
        }
    }

    // metodos rellenar
     // vasos
    int xx = 0;

    // cafe
    public void rellenarCafe() {
        int xx = Integer.parseInt(JOptionPane.showInputDialog("cuantos Gramos de cafe quiere poner"));
        int gcafe = getgCafeA();
        xx = xx + gcafe;

        if (xx > 1000) {
            JOptionPane.showMessageDialog(null, "Alerta tenga cuidado no cargar en exceso");
            xx = 1000;
        } else if (xx <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input. No changes have been made.");
            return;
        }
        setgCafeA(xx);
        JOptionPane.showMessageDialog(null, "su cafetera esta cargada con " + getgCafeA() + "g de cafe");
    }

    // leche
    public void rellenarLeche() {
        int xx = Integer.parseInt(JOptionPane.showInputDialog("cuantos g de leche quiere poner"));
        int gleche = getGlecheA();
        xx = gleche + xx;

        if (xx > 1000) {
            JOptionPane.showMessageDialog(null, "Alerta tenga cuidado no cargar en exceso");
            xx = 1000;
        } else if (xx <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
            return;
        }
        setGlecheA(xx);
        JOptionPane.showMessageDialog(null, "su cafetera esta cargada con " + getGlecheA() + "g de leche");
    }

    // cacao
    public void rellenarCacao() {
        int xx = Integer.parseInt(JOptionPane.showInputDialog("cuantos Gramos de cacao quiere poner"));
        int gcacao = getgCacacoA();
        xx = gcacao + xx;

        if (xx > 1000) {
            JOptionPane.showMessageDialog(null, "Alerta tenga cuidado no cargar en exceso");
            xx = 1000;
        } else if (xx <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
            return;
        }
        setgCacacoA(xx);
        JOptionPane.showMessageDialog(null, "su cafetera esta cargada con " + getgCacacoA() + "g de cacao");
    }

    // agua
    public void rellenarAgua() {
        int xx = Integer.parseInt(JOptionPane.showInputDialog("cuantos ml de agua quiere poner"));
        int mAgua = getMlAgua();
        xx = mAgua + xx;

        if (xx > 1000) {
            JOptionPane.showMessageDialog(null, "Alerta tenga cuidado no cargar en exceso");
            xx = 1000;

        } else if (xx <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
            return;
        }
        setMlAgua(xx);
        JOptionPane.showMessageDialog(null, "su cafetera esta cargada con " + getMlAgua() + "ml de agua");
    }

    // vasos
    public void rellenarVasos() {
        int vasoAct = getVasosNum();
        int xx = Integer.parseInt(JOptionPane.showInputDialog("cuantos vasos quiere poner"));

        if (xx > 500) {
            JOptionPane.showMessageDialog(null, "Alerta tenga cuidado no cargar en exceso");
            setVasosNum(500);
        } else if (xx < 500) {
            vasoAct += xx;
            if (vasoAct > 500) {
                vasoAct = 500;
            }
            setVasosNum(vasoAct);
        }
        JOptionPane.showMessageDialog(null, "su cafetera esta cargada con " + getVasosNum() + "N° de vasos");
    }

    // metodos GET y SET

    public double getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(double numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public ArrayList<Cafe> getCafesArray() {
        return cafesArray;
    }

    public void setCafesArray(ArrayList<Cafe> cafesArray) {
        this.cafesArray = cafesArray;
    }

    public int getVasosNum() {
        return vasosNum;
    }

    public void setVasosNum(int vasosNum) {
        this.vasosNum = vasosNum;
    }

    public int getgCafeA() {
        return gCafeA;
    }

    public void setgCafeA(int gCafeA) {
        this.gCafeA = gCafeA;
    }

    public int getGlecheA() {
        return glecheA;
    }

    public void setGlecheA(int glecheA) {
        this.glecheA = glecheA;
    }

    public int getgCacacoA() {
        return gCacacoA;
    }

    public void setgCacacoA(int gCacacoA) {
        this.gCacacoA = gCacacoA;
    }

    public int getMlAgua() {
        return mlAgua;
    }

    public void setMlAgua(int mlAgua) {
        this.mlAgua = mlAgua;
    }

}// fin de maquina.java
