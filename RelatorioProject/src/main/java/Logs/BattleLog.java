package Logs;

import java.time.LocalDate;

public class BattleLog {
    private LocalDate DataDaPartida;
    private String Heroi;
    private boolean Ganhou;
    private String Monstro;
    private int Rodadas;


    public BattleLog(LocalDate dataDaPartida, String heroi, boolean ganhou, String monstro, int rodadas) {
        DataDaPartida = dataDaPartida;
        Heroi = heroi;
        Ganhou = ganhou;
        Monstro = monstro;
        Rodadas = rodadas;
    }
    public LocalDate getDataDaPartida() {
        return DataDaPartida;
    }
    public String getHeroi() {
        return Heroi;
    }
    public boolean isGanhou() {
        return Ganhou;
    }
    public String getMonstro() {
        return Monstro;
    }
    public int getRodadas() {
        return Rodadas;
    }
}

