/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ericoe
 */ 


public class Produto {
    private int id;
    private String nome;
    private String ram;
    private String tela;
    private String CPU;
    private String resolucao;
    private String placavdo;
    private String descricao;
    private String wifi;
    private String bluetooth;
    private String numpad;
    

    public void setId(int ID) {
        this.id = ID;
    }
    public int getId() {
        return id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }
    
    public String getram() {
        return ram;
    }

    public void setram(String ram) {
        this.ram = ram;
    }
    public String gettela() {
        return tela;
    }

    public void settela(String tela) {
        this.tela = tela;
    }
    public String getCPU () {
        return CPU;
    }
    
    public void setCPU(String Cpu) {
        this.CPU = Cpu;
    }
    public String getresolucao() {
        return resolucao;
    }

    public void setresolucao(String resolucao) {
        this.resolucao = resolucao;
    }
    public String getplacavdo() {
        return placavdo;
    }

    public void setplacavdo(String placavdo) {
        this.placavdo = placavdo;
    }
    
    public String getdescricao() {
        return descricao;
    }
    
    public void setdescricao(String Descricao) {
        this.descricao = Descricao;
    }
    public String getwifi() {
        return wifi;
    }

    public void setwifi(String wifi) {
        this.wifi = wifi;
    }
    public String getbluetooth() {
        return bluetooth;
    }

    public void setbluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }
    public String getnumpad() {
        return numpad;
    }

    public void setnumpad(String nunpad) {
        this.numpad = nunpad;
    }
}