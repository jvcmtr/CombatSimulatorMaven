import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import Creatures.BaseClass;
import combatRules.CombatHelper;

import Console.Console;
import Repository.IRepository;
import Repository.RepositoryCSV;

public class Program {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Console out = new Console(90);
        IRepository repos = new RepositoryCSV();

        String input = "";

        while (true) {

            Character boneco = InitCharacter(scan, out);
            String s = runRandomBattle(boneco);
            AddToLog(repos, s, boneco);

            out.Open()
                    .printLogo()
                    .printCentralized(s)
                    .printCentralized("Digite ESC para sair")
                    .Close();

            input = scan.nextLine();
            out.TrueClear();

            if (input.equals("ESC"))
                break;
        }
    }









    
    public static String runRandomBattle(Character c) {
        BaseClass[] criaturas = CombatHelper.getIniciativa(c.getHeroi(), CombatHelper.getRandomMonster());
        int rounds = 0;
        while (true) {
            rounds++;
            if (criaturas[0].getFatorDeAtaque() > criaturas[1].getFatorDeDefesa())
                criaturas[0].attack(criaturas[1]);

            if (criaturas[1].isDead())
                break;

            criaturas = new BaseClass[] {
                    criaturas[1],
                    criaturas[0]
            };
        }

        if (criaturas[0] == c.getHeroi()) {
            return LocalDate.now() + "," + criaturas[0].getName() + ",GANHOU," + criaturas[1].getName() + "," + rounds;
        }

        return LocalDate.now() + "," + criaturas[1].getName() + ",PERDEU," + criaturas[0].getName() + "," + rounds;
    }

    public static void AddToLog(IRepository repos,  String s, Character c) {
        String filename = c.getNickname() + ".csv";
        repos.Save(s, filename);
    }

    public static Character InitCharacter(Scanner scan, Console out) {
        boolean run = false;
        String nickname = "";
        BaseClass charClass = null;

        while (!run) {
            nickname = EscolherNickname(scan, out);
            charClass = EscolherClasse(nickname, scan, out);
            run = Confirmar(charClass, nickname, scan, out);
        }

        Character c = new Character(nickname, charClass);
        return c;
    }

    public static String EscolherNickname(Scanner scan, Console out) {
        out.Clear()
                .printTitle("bem Vindo ao medieval Battle !")
                .println("")
                .println("")
                .println(" Digite o seu nickname : _ _ _")
                .Close();
        return scan.nextLine();
    }

    public static BaseClass EscolherClasse(String nickname, Scanner scan, Console out) {
        String erro = "";
        BaseClass charClass = null;
        BaseClass[] classes = CombatHelper.availableClasses();

        while (charClass == null) {
            out.Clear()
                    .printTitle("bem Vindo ao medieval Battle !")
                    .println("")
                    .println("")
                    .println("+ Digite o seu nickname : " + nickname)
                    .println("")
                    .println("+ Digite o numero da classe que deseja escolher : ");

            for (int i = 0; i < classes.length; i++) {
                out.println("    [" + i + "] " + classes[i].getDetails());
            }

            if (!erro.equals(""))
                out.println("").println(erro);
            out.Close();

            try {
                int i = scan.nextInt();
                charClass = classes[i];
            } catch (IndexOutOfBoundsException e) {
                erro = "# ERRO : Digite um numero entre 0 e " + classes.length;
                continue;
            } catch (InputMismatchException e) {
                erro = "# ERRO : Você deve digitar um numero";
                continue;
            }
        }
        return charClass;
    }

    public static boolean Confirmar(BaseClass charClass, String nickname, Scanner scan, Console out) {
        String inp = "";
        while (!inp.equals("y") && !inp.equals("n")) {
            out.Clear()
                    .printCentralized("+ Confirme seu personagem :")
                    .println("")
                    .println("    nickname : " + nickname)
                    .println("    classe : ")
                    .println("     " + charClass.getDetails())
                    .println("")
                    .printCentralized("[y] OK  /  [n] VOLTAR");

            if (!inp.equals(""))
                out.println("# ERRO : [" + inp + "] Não é uma entrada valida ");

            out.Close();
            inp = scan.nextLine();
        }
        return inp.equals("y");
    }

}

