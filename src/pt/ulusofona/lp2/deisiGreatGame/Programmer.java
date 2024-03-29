package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmer {
    int id;
    String nome;
    ArrayList<String> linguagensFavoritas;
    ProgrammerColor cor;
    String estado = "Em Jogo";
    int posPlayer = 1;
    Abismo abismo;
    ArrayList<Ferramenta> ferramentas = new ArrayList<>();
    boolean presoNoCicloInfinito=false;
    ArrayList<Integer> guardaPosicao = new ArrayList<>();
    ArrayList<String> linguagensFavoritasKotlin = new ArrayList<>();

    public Programmer(String nome, int id, ProgrammerColor cor, ArrayList<String> linguagensFavoritas,int posPlayer) {
        this.id = id;
        this.nome = nome;
        this.linguagensFavoritas = linguagensFavoritas;
        this.cor = cor;
        this.posPlayer = posPlayer;
    }

    public Programmer(int id, String nome, ArrayList<String> linguagensFavoritas, ProgrammerColor cor) {
        this.id = id;
        this.nome = nome;
        this.linguagensFavoritas = linguagensFavoritas;
        this.cor = cor;
        String[] abc = linguagensFavoritas.get(0).split(";");
        this.linguagensFavoritasKotlin = new ArrayList<>(List.of(abc)) ;

    }

    public Programmer(int id, String nome, ArrayList<String> linguagensFavoritas, ProgrammerColor cor, String estado, int posPlayer, ArrayList<Ferramenta> ferramentas,
                      boolean presoNoCicloInfinito, ArrayList<Integer> guardaPosicao) {
        this.id = id;
        this.nome = nome;
        this.linguagensFavoritas = linguagensFavoritas;
        this.cor = cor;
        this.estado = estado;
        this.posPlayer = posPlayer;
        this.ferramentas = ferramentas;
        this.presoNoCicloInfinito = presoNoCicloInfinito;
        this.guardaPosicao = guardaPosicao;
    }

    public Programmer(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getArrayListGuardaPosicao() {
        return guardaPosicao;
    }

    public void adicionaGuardaPosicao(int pos) {
        this.guardaPosicao.add(pos);
    }

    public Programmer(ArrayList<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }

    public Programmer(Abismo abismo) {
        this.abismo = abismo;
    }

    public ArrayList<Ferramenta> getFerramentas() {
        return ferramentas;
    }
    public boolean getFerramentas(int idAEntrar) {
        for (int i = 0; i < ferramentas.size() ; i++) {
            if (ferramentas.get(i).id == idAEntrar){
                return true;
            }
        }
        return false;
    }

    public void adicionaFerramenta(Ferramenta ferramenta){
        this.ferramentas.add(ferramenta);
    }

    public void removeFerramenta(int idAEntrar){
        for (int i = 0; i < ferramentas.size() ; i++) {
            if (ferramentas.get(i).id == idAEntrar){
                ferramentas.remove(ferramentas.get(i));
            }
        }
    }

    public ArrayList<String> getLinguagensFavoritasKotlin() {
        return linguagensFavoritasKotlin;
    }

    public Programmer() {
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.nome;
    }

    public ArrayList<String> getLinguagensFavoritas() {
        return linguagensFavoritas;
    }

    public ProgrammerColor getColor(){
        return this.cor;
    }

    public int getPosPlayer(){
        return this.posPlayer;
    }

    public int getPosPlayerReset(int posicao){
        return this.posPlayer=posicao;
    }

    public String getEstado(){
        return this.estado;
    }

    void andaParaAFrente(int posicoesAAlterar){
       this.posPlayer+= posicoesAAlterar;
    }

    void andaParaTras(int tamanhoDoTabuleiro,int posicoesAAlterar){
        int posicaoInicial = this.posPlayer + posicoesAAlterar;
        this.posPlayer = tamanhoDoTabuleiro - (posicaoInicial-tamanhoDoTabuleiro);
    }

    public boolean temAlinguagem(String linguagem){
        for (int i = 0; i <linguagensFavoritasKotlin.size() ; i++) {
            if (linguagensFavoritasKotlin.get(i).equals(linguagem)){
                return true;
            }
        }
        return false;
    }

    public void alteraEstado() {
        this.estado="Ausente";
    }
    public void alteraPresoNoCicloInfinito() {
        if (this.presoNoCicloInfinito){
            this.presoNoCicloInfinito=false;
        }else {
            this.estado = "Em Jogo";
            this.presoNoCicloInfinito=true;
        }

    }

    public boolean estaPresoNoCicloInfinito() {
        this.estado = "Ausente";
        return this.presoNoCicloInfinito;
    }

    @Override
    public String toString() {

        StringBuilder outputLinguagensFavoritas = new StringBuilder();

        if(linguagensFavoritas==null || linguagensFavoritas.size()==0){
            //OU CRIAR -> Programmer a = new Programmer();
            outputLinguagensFavoritas.append("Não tem");
        }else{

            for (int i = 0; i < linguagensFavoritas.size() ; i++) {
                if (i==0){
                    outputLinguagensFavoritas.append(linguagensFavoritas.get(i));
                }else{
                    outputLinguagensFavoritas.append(";").append(linguagensFavoritas.get(i));
                }
            }
        }

        String[] stringNormal = outputLinguagensFavoritas.toString().split(";");
        Arrays.sort(stringNormal);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < stringNormal.length; i++) {
            if(i==0){
                output.append(stringNormal[i]);
            } else {
                output.append(";").append(stringNormal[i]);
            }
        }

        String resultado = output.toString().replace(";","; ");


        //Stringbuilder das ferramentas
        StringBuilder outputferramentas = new StringBuilder();

        if (ferramentas.size() == 0){
            outputferramentas.append("No tools");
        }else{
            for (int i = 0; i < ferramentas.size() ; i++) {
                if (i == 0){
                    outputferramentas.append(ferramentas.get(i));
                }else {
                    outputferramentas.append("; ").append(ferramentas.get(i));
                }
            }
        }

        return id + " | " + nome + " | " + posPlayer + " | " + outputferramentas + " | " + resultado + " | " + estado;
    }

}
