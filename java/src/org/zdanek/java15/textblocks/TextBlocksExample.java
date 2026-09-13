package org.zdanek.java15.textblocks;


//https://docs.oracle.com/en/java/javase/25/language/text-blocks.html#GUID-B1AF2D0B-C89F-478B-8C98-E8FC3271DC5E
public class TextBlocksExample {

    void main(){
        // Using a literal string
        String dqName = "Pat Q. Smith";

        IO.println(dqName);

        // Using a text block
        String tbName = """
                Pat Q. Smith""";

        IO.println(tbName);

        String colors = """
        red  \s
        green
        blue \s
        """;
        IO.println(colors);


        String output = """
    Name: %s
    Phone: %s
    Address: %s
    Salary: $%.2f
    """.formatted("Zbyszek", "111 222 333", "Wojskowa", 1000000.00);
        IO.println(output);
    }
}
