package Console;

import java.util.function.Consumer;

public class Console {
    public int Width = 80;
    public int Spacing = 3;
    public String Embelishment = " --== ";

    public Console(int width, int spacing) {
        Spacing = spacing;
        Width = width;
    }

    public Console(int width) {
        Width = width;
    }

    public Console(String spacing) {
        Spacing = spacing.length();
    }

    public Console Clear() {
        System.out.println("\n\n\n");
        printTopBorder();
        // │─┌ └┘░▒▓┐
        return this;
    }

    public static void TrueClear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public Console Open() {
        printTopBorder();
        return this;
    }

    public Console Close() {
        printBottomBorder();
        return this;
    }

    public Console println(String s) {

        forLinesIn(s, (ln) -> {
            printBorderIn();
            System.out.print(ln);
            int remainingSpace = Width - ln.length();
            for (int i = 0; i < remainingSpace; i++) {
                System.out.print(" ");
            }
            printBorderOut();
        });
        return this;
    }

    public Console printTitle(String title) {

        String[] lines = GetTitleLines(title);
        for (String s : lines) {
            println(s);
        }

        println("");
        return this;
    }

    public Console printCentralized(String s) {
        forLinesIn(s, (ln) -> {
            printBorderIn();
            ln = Centralize(ln);
            System.out.print(ln);
            int remainingSpace = Width - ln.length();
            for (int i = 0; i < remainingSpace; i++) {
                System.out.print(" ");
            }
            printBorderOut();
        });
        return this;
    }

    private String Centralize(String s) {
        int midPoint = (int) (s.length()) / 2;
        int d = ((int) Width / 2) - midPoint;
        for (int i = 0; i < d; i++) {
            s = " " + s;
        }
        return s;
    }

    private void forLinesIn(String s, Consumer<String> lambda) {
        String[] ar = splitLines(s, Width);
        for (String line : ar) {
            lambda.accept(line);
        }
    }

    private static String[] splitLines(String s, int width) {
        if (s.length() <= width) {
            return new String[] { s };
        }

        String line = "";
        int split = width;
        for (int i = width; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                split = i;
                break;
            }
        }
        line = s.substring(0, split);
        String[] remain = splitLines(s.substring(split), width);

        String[] r = new String[1 + remain.length];
        r[0] = line;
        for (int i = 1; i < r.length; i++) {
            r[i] = remain[i - 1];
        }
        return r;
    }

    private void printTopBorder() {
        System.out.print("░░░░" + Spacing("░"));
        printAllLine("░");
        System.out.println(Spacing("░") + "░░░░");

        System.out.print("░░▒▒" + Spacing("▓"));
        printAllLine("▓");
        System.out.println(Spacing("▓") + "▒▒░░");

        System.out.print("░▒▓┌" + Spacing("─"));
        printAllLine("─");
        System.out.println(Spacing("─") + "┐▓▒░");

        for (int i = 0; i < Spacing; i += 2) {
            println(" ");
        }

    }

    private void printBottomBorder() {
        for (int i = 0; i < Spacing; i += 2) {
            println(" ");
        }

        System.out.print("░▒▓└" + Spacing("─"));
        printAllLine("─");
        System.out.println(Spacing("─") + "┘▓▒░");

        System.out.print("░░▒▒" + Spacing("▓"));
        printAllLine("▓");
        System.out.println(Spacing("▓") + "▒▒░░");

        System.out.print("░░░░" + Spacing("░"));
        printAllLine("░");
        System.out.println(Spacing("░") + "░░░░");
    }

    private String Spacing(String s) {
        String r = "";
        for (int i = 0; i < Spacing; i++) {
            r += s;
        }
        return r;
    }

    private void printAllLine(String s) {
        int l = Width / s.length();
        for (int i = 0; i < l; i++) {
            System.out.print(s);
        }
    }

    private void printBorderIn() {

        System.out.print("░▒▓│" + Spacing(" "));
    }

    private void printBorderOut() {

        System.out.println(Spacing(" ") + "│▓▒░");
    }

    private String[] GetTitleLines(String s) {
        String title = "";
        for (char c : s.toUpperCase().toCharArray()) {
            title += "a" + c;
        }

        title += "a";
        int d = Width - (Embelishment.length() * 2);
        String[] split = splitLines(title, d);

        for (int i = 0; i < split.length; i++) {
            String line = split[i];
            line = Embelishment + line + reverseString(Embelishment);
            line = line.replace("a", " ");
            line = Centralize(line);
            split[i] = line;
        }

        return split;
    }

    private String reverseString(String s) {
        String r = "";
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            r += s.charAt(len - i);
        }
        return r;
    }

    public Console printLogo() {
        String[] s = new String[] {
                "                           .-.      ",
                "                          {{#}}     ",
                "          {}               8@8      ",
                "        .::::.             888      ",
                "    @\\\\/W\\/\\/W\\//@         8@8      ",
                "     \\\\/^\\/\\/^\\//     _    )8(    _ ",
                "      \\_O_{}_O_/     (@)__/8@8\\__(@)",
                " ____________________ `~\"-=):(=-\"~` ",
                "|<><><>  |  |  <><><>|     |.|      ",
                "|<>      |  |      <>|     |S|      ",
                "|<>      |  |      <>|     |'|      ",
                "|<>   .--------.   <>|     |.|      ",
                "|     |   ()   |     |     |P|      ",
                "|_____| (O\\/O) |_____|     |'|      ",
                "|     \\   /\\   /     |     |.|      ",
                "|------\\  \\/  /------|     |U|      ",
                "|       '.__.'       |     |'|      ",
                "|        |  |        |     |.|      ",
                ":        |  |        :     |N|      ",
                " \\       |  |       /      |'|      ",
                "  \\<>    |  |    <>/       |.|      ",
                "   \\<>   |  |   <>/        |K|      ",
                "    `\\<> |  | <>/'         |'|      ",
                "jgs   `-.|__|.-`           \\ /      ",
                "                            ^        "
        };

        for (String string : s) {
            printCentralized(string);
        }

        return this;
    }
}
