import java.util.Scanner;
import java.util.ArrayList;

import Logs.*;
import Console.Console;
import Repository.IRepository;
import Repository.RepositoryCSV;


public class Program {
    public static void main(String[] args) {

        String input = "";
        Scanner scan = new Scanner(System.in);
        Console out = new Console(90);
        IRepository repos = new RepositoryCSV();

        while (true) {

            UserLogs userLog = getUserLog(repos, out, scan);
            displayLog(userLog, out, scan);

            out.Open()
                    .printCentralized("Digite ESC para sair")
                    .Close();
            input = scan.nextLine();
            out.TrueClear();

            if (input.equals("ESC"))
                break;
        }
    }

    private static UserLogs getUserLog(IRepository repos,Console out, Scanner scan) {
        BattleLog[] userLog = null;
        String nickname = "";

        String ERRO = "";
        boolean done = false;

        while (!done) {
            out.Clear()
                    .printLogo()
                    .println("")
                    .printTitle("Veja seu historico de combate ")
                    .println("")
                    .println("")
                    .println(" Digite o seu nickname : _ _ _")
                    .println(ERRO)
                    .Close();

            nickname = scan.nextLine();
            userLog = getLog(repos, nickname);

            if (userLog.length == 0)
                ERRO = "Nao foi encontrado um jogador com o nome " + nickname;
            else
                done = true;
        }
        return new UserLogs(userLog, nickname);
    }

    public static void displayLog(UserLogs log, Console out, Scanner scan) {
        String[] herois = log.getHeroisJogados();

        out.Clear()
                .printTitle("Bem vindo " + log.getNickname())
                .printCentralized("PONTOS : " + log.getPontosTotais())
                .printCentralized(" " + log.getIndiceDeVitoria())
                .println("")
                .println("* Nickname  . . . . . . . . . . " + log.getNickname())
                .println("* Heroi mais jogado . . . . . . " + log.getHeroiMaisJogado())
                .println("* Monstro mais Enfrentado . . . " + log.getMostroMaisEnfrentado())
                .println("* Dia mais jogado . . . . . . . " + log.getDiaMaisJogado())
                .println("")
                .println("")
                .println("")
                .printTitle("Estatisticas com cada heroi");

        for (String heroi : herois) {
            out.println("")
                    .printCentralized(heroi.toUpperCase())
                    .println("Pontos: " + log.getPontosPorHeroi(heroi))
                    .println("      " + log.getIndiceDeVitoriaPorHeroi(heroi))
                    .println("")
                    .println("Monstro mais derrotado :  " + log.MostroMaisDerrotadoPorHeroi(heroi))
                    .println("Monstro mais perigoso  :  " + log.MostroMaisVitoriosoContraHeroi(heroi))
                    .println("")
                    .println("");
        }

        out.Close();
        scan.nextLine();
    }

    private static BattleLog[] getLog(IRepository repos, String nickname) {
        String[] lines = repos.Load(nickname);
        ArrayList<BattleLog> logs = new ArrayList<BattleLog>();

        for (String line : lines) {
            String[] props = line.split(",");
            BattleLog b = new BattleLog(
                    Utils.dtFromString(props[0]),
                    props[1],
                    (props[2].equals("GANHOU")),
                    props[3],
                    Integer.parseInt(props[4]));
            logs.add(b);
        }

        return logs.toArray(new BattleLog[logs.size()]);
    }

}
