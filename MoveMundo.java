import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Essa classe fornece é base para todas as outras fases.
 * Ela movimenta todos os elementados setados como movíveis.
 * Dando a impressão que o cenário é muito maior dos que limites, da tela.  
 * @author jeferson
 * @since d2013
*/

public abstract class MoveMundo extends World implements Reiniciavel, Pausavel
{
    /**
     * Construtor da classe MoveMundo
     * Recebe como parâmetro um inteiro referente a largura
     * outro referente a altura, e um a largura totalDoMundo
     * ele passa as características a super classe World
     * passa dois parâmetros extras, 1 que se refere aos pixels 1x1
     * e false, que torna o mundo ilimitado.
     * @param larguraTela - largura da tela, alturaTela - altura da tela, larguraTotal - largura simulada.
   */
   public MoveMundo(int larguraTela, int alturaTela, int larguraTotal){
        super(larguraTela, alturaTela,1,false);
        this.larguraTela=larguraTela;
        tamanhoDoMundo=larguraTotal;
   }
    
   /**
    *   Este método, recebe o personagem principal,
    *   adiciona ele nas cordenadas x e y
    *   e seta o a distancia limite entre o personagem e a tela
    *   para dar o início a movimentação do cenário
    *   @param personagemPrincipal - X e Y - cordenada X e Y na qual o persoangem principal será setado, distanciaDaTela - distancia da tela que deve ser mantida.   
    */
    public void adicionarPersonagemPrincipal(Actor personagemPrincipal, int x, int y, int distanciaDaTela){
        this.personagemPrincipal=personagemPrincipal;
        posicaoInicialX=x;
        posicaoInicialY=y;
        this.distanciaDaTela=distanciaDaTela;
        addObject(personagemPrincipal, x, y);
    }
    
    /**
     * Este método adicina um objeto ao mundo
     * nas cordenadas x e y
     * caso ele seja movível ele é guardado
     * na coleção de atores movíveis
     * @param objeto - ator a ser adicionado o mundo,x e y são as cornedadas na qual o personagem será adicionado,
     * eMovivel - true caso o personagem seja movível.
     */
    public void adicionarObjeto(Actor objeto, int x, int y, boolean eMovivel){
        if(eMovivel==true){
           atoresMoviveis.add(objeto);
           addObject(objeto,x,y);
        }
        else
            addObject(objeto,x,y);
    }
    /**
     * Este metodo primeiramente remove um objeto da lista de atores movíveis
     * após estre procedimento ele remove o objeto do mundo
     * @param objeto - ator a ser removido do mundo.
     */
    public void removerObjeto(Actor objeto){
        atoresMoviveis.remove(objeto);
        removeObject(objeto);
    }
    
    /**
     * Este método executa a movimentação dos atores movíveis
     * Se o personagem atingir o final dos cenários.
     * Ele seta o personagem a posição limite
     * Se o personagem não atingiu nenhum limite e ultrapassou
     * o limite de distancia da tela, ele calcula os passos andados 
     * e seta o personagem a distancia limite.
     * caso o limite+osPassosAndados forem iguais ao tamanho do mundo
     * o personagem é liberado para atingir os limites da tela
     */
    public void moverMundo(){
        distanciaDaTelaTotal=getWidth()-distanciaDaTela;
        if(verificaDirecaoPersonagem()==true){  
            if((passosAndados+distanciaDaTelaTotal)>=tamanhoDoMundo){
                if(personagemPrincipal.getX()>=getWidth()-3)
                    personagemPrincipal.setLocation((getWidth()-3), personagemPrincipal.getY());
            }
            else
                if(personagemPrincipal.getX()>=distanciaDaTelaTotal){
                    calculaPassosAndados();
                    for(Actor k: atoresMoviveis)
                    k.setLocation(k.getX()-distanciaAMoverAtores(), k.getY());
                    personagemPrincipal.setLocation(distanciaDaTelaTotal, personagemPrincipal.getY());
            }
        }else
            if(passosAndados<=0){
                    if(personagemPrincipal.getX()<1)
                        personagemPrincipal.setLocation(4, personagemPrincipal.getY());
            }else
                if(personagemPrincipal.getX()<=distanciaDaTela){
                    calculaPassosVolta();
                    for(Actor k: atoresMoviveis)
                        k.setLocation(k.getX()-distanciaAMoverAtoresVolta(), k.getY());
                        personagemPrincipal.setLocation(distanciaDaTela, personagemPrincipal.getY());
                }
    }
    
    /**
     * Este método retorna o personagem principal
     * @return Actor - retorna o ator principal.
     */
    public Actor getPersonagemPrincipal(){
        return this.personagemPrincipal;
    }
    /**
     * Este método é responsável por calcular
     * os passos andados do personagem
     */
    public void calculaPassosAndados(){
        passosAndados+=(personagemPrincipal.getX()-distanciaDaTelaTotal);
    }
    /**
     * Este método calcula os passos de volta do personagem
     */
    public void calculaPassosVolta(){
        passosAndados-=(distanciaDaTela-personagemPrincipal.getX());
    }
    
    /**
     * Este método calcula a distancia
     * a mover os personagens, com base na distancia
     *  desvio  do personagem na cordena x, en relação
     *  ao limite imposto pela distancia da tela
     *  @return int - distancia na qual os atores devem ser movidos caso o personagem esteja andando em direção a direita.
     */
    public int distanciaAMoverAtores(){
        return (personagemPrincipal.getX()-distanciaDaTelaTotal);
    }
    /**
     * Este método calcula a distancia a mover
     * os personagens caso o personagem volte
     * em relação ao cenário.
     * @return int - distancia na qual os atores moviveis devem ser movidos caso o personagem esteja voltando no cenário.
     */
    public int distanciaAMoverAtoresVolta(){
        return (personagemPrincipal.getX()-distanciaDaTela);
    }
   
    /**
     * verifica a direcao em que o personagem
     * se move.
     * @return boolean - retorna a direção do personagem, true significa direita, false esquerda. 
     */
    public boolean verificaDirecaoPersonagem(){
        return (((Jogador)personagemPrincipal).getDirecao());
    }
    
    public void reiniciarParcialmente(){
        for(Actor k: atoresMoviveis)
                        k.setLocation(k.getX()+passosAndados, k.getY());
                        personagemPrincipal.setLocation(distanciaDaTela, posicaoInicialY);
        passosAndados=0;                
    }
    

    private int semIdeia;
    private Actor personagemPrincipal;
    private boolean personagemCaminhandoParaDireita;
    private int distanciaDaTelaTotal;
    private boolean direcaoEsquerda;
    private int posicaoInicialX;
    private int posicaoInicialY;
    private int passosAndados;
    private int larguraTela;
    private int tamanhoDoMundo;
    private int incioMundo;
    private int distanciaDaTela;
    private List<Actor>atoresMoviveis=new ArrayList();
 
}
        