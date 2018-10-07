import greenfoot.*;

/**
 * Classe base de Oberon
 * Fornece funcionalidades básicas
 * como gravidade, danos e teste de colisao
 */
public abstract class Jogador extends Actor implements Dano 
{
    /**
     * Faz a gravidade  funcionar
     * Se o personagem está acima do chão,
     * ele é movido para baixo, caso contrário
     * ele pode pular
     */
    protected void gravidade()
    {
        if(!isTouching(Base.class)&&pulando==false){
            if(podeDescer==true)
                setLocation(getX(),getY()+4);
        }
        else
            if(podePular==false)
                podePular=true;
            
   }
    
    /**
     * Este método deixa o dano true, assim
     * diferindo dano ao Oberon.
     * Este dano é temporizado;
     */
    public void dano()
    {
        if(tempoDeEsperaAteProximoDano==0){
            this.dano=true;
            tempoDeEsperaAteProximoDano=100;
        }
        if(tempoDeEsperaAteProximoDano!=0)
            tempoDeEsperaAteProximoDano--;
        
    }
    
    /**
     * Este dano deixa o dano true, assim 
     * diferindo dano ao Oberon.
     * Este dano pode ser usado constantemente.
     */
    public void dano2(){
        this.dano=true;
    }
    
    /**
     * Este método verifica se o personagem está
     * interceptando qalquer Inimigo.
     */
    protected void colisao()
    {   possivelColisor=getOneIntersectingObject(Inimigos.class);
        
        if(possivelColisor!=null){
            dano();
        }
          colisaoCenario();
        
    }

    /**
     * Este método verifica se o personagem está colidindo
     * com algum objeto do cenário.
     */
    private void colisaoCenario(){
        possivelColisor=getOneIntersectingObject(Terrain.class);
        if(possivelColisor!=null){
            if(getY()>possivelColisor.getY()){
                    podePular=false;
                    podeDescer=true;
                    if(getX()>possivelColisor.getX()){
                        podeAndarEsquerda=false;
                        podeAndarDireita=true;
                        podeDescer=true;
                        if(!isTouching(Base.class)){
                            podePular=false;
                            podeSubir=false;
                        }else{
                            podePular=true;
                            podeSubir=false;
                        }
                    }
                    if(getX()<possivelColisor.getX()){
                        podeAndarDireita=false;
                        podeAndarEsquerda=true;
                        podeDescer=true;
                        if(!isTouching(Base.class)){
                            podePular=false;
                            podeSubir=false;
                        }else{
                            podePular=true;
                            podeSubir=false;
                        }
                    }
            }
        
            if(getY()<possivelColisor.getY()){
                podeDescer=false;
                podePular=true;
                podeSubir=true;
            }
        
            if(getY()==possivelColisor.getY()||getY()>possivelColisor.getY()-40){
                    if(getX()>possivelColisor.getX()+1){
                        podeAndarEsquerda=false;
                        podeAndarDireita=true;
                        podeDescer=true;
                    }
                    if(getX()<possivelColisor.getX()-1){
                        podeAndarDireita=false;
                        podeAndarEsquerda=true;
                        podeDescer=true;
                    }
                }
        }else{
            podeAndarDireita=true;
            podeAndarEsquerda=true;
            podeSubir=true;
            podeDescer=true;
        }
    
        if(isTouching(Base.class)){
            chao=getOneIntersectingObject(Base.class);
            if(getY()>chao.getY()+2){
                setLocation(getX(),getY()+4);
                podeSubir=false;
            }
        }
    }
    
    /**
     * Este método retorna um boolean
     * referente a direção do personagem
     * return boolean - representa a direção na qual o personagem se encontra. true para direita e false esquerda.
     */
    public boolean getDirecao(){
        return this.direita;
    }
    
    /**
     * Este método retorna a energia do personagem
     * @return Energia retorna a enregia do jogador.
     */
    public Energia getEnergia(){
        return this.energia;
    }
    
    private Actor chao;
    private Actor possivelColisor;
    protected boolean pulando=false;
    protected boolean podeAndarDireita=true;
    protected boolean podeAndarEsquerda=true;
    protected boolean podeSubir=true;
    protected boolean podeDescer=true;
    protected boolean dano;
    private int tempoDeEsperaAteProximoDano;
    protected boolean podePular;
    protected boolean direita=true;
    protected int alturaMaximaDoPulo=-145;
    protected Energia energia= new Energia();
    protected int valorDano2;
    
}
    


