import greenfoot.*;
/**
 * Este é o sexto inimigo,
 * suas principais funcionalidades são
 * andar, exibir sua animação de ataque,
 * e atacar.
 * 
 * @since Novembro,2013.
 */
public class Inimigo06 extends Inimigos
{
    public Inimigo06(){
        setAlturaPadrao(22);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo. 
     * @param world
     */
    protected void addedToWorld(World world){
           hp = new VidaInimigos();
           getWorld().addObject(hp, getX(), getY()-50);    
           inverterImagem();
           alturaNoAtaque=getY()-15;
           alturaFixa=getY();
        }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        if(!morreu()){
            if(parar==false){
                if(ataque==true){
                    ((Jogador)possivelColisor).dano();
                    if(ataqueExecutado==false){    
                        bater();
                        levouDano();
                        gravidade();
                    }
                }else{
                    frame();
                    gravidade();
                    levouDano();
                    andar();
                    possivelColisor = colisao();
                    ataqueExecutado=false;
                }
            }else{
                levouDano();
                colisao();
            }
        }
    }
    
    /**
     * Este método é responsável por verificar a direção do ator.
     */
    public void andar(){
        if(moveBack==false&&direcao==1)
           mover();
           
           if(moveBack==true&&direcao==1){
           direcao=2;
           mover();
           moveBack=false;
           inverterImagem();
        }
        
        if(moveBack==false&&direcao==2)
           mover(); 
           
           if(moveBack==true&&direcao==2){
           direcao=1;
           mover();
           moveBack=false;
           inverterImagem();
        }
    }
    
    /**
     * Este método é responsável por exevutar
     * a movimentação do ator e chamar o método
     * de movimentação da vida.
     */
    public void mover(){
        switch (direcao){
        case 1: setLocation(getX()-1, getY());
                movimentaVida();
        break;
        case 2:setLocation(getX()+1, getY());
                movimentaVida();
        break;
       }
    }
    
    
    /**
     * Este método verifica se o ator levou dano,
     * caso tenha levado ele perde vida.
     */
    public void levouDano(){
        if(dano==true){
             hp.perderPontoVida();
             dano=false;
         }
         if(dano2==true){
             for(int x=0;x<valorDano2Padrao;x++){
                hp.perderPontoVida();
                if(hp.getPontoVida()==0)
                    break;
            }
             dano2=false;   
         }
    }
    
    /**
     * Este método verifica se o ator morreu,
     * caso tenha morrido ele  remove a vida, e o ojeto.
     */
    public boolean morreu(){
        if(hp.getPontoVida()<=0)
          {
          Actor ob =((MoveMundo)getWorld()).getPersonagemPrincipal();
          ((Jogador)ob).getEnergia().recuperarPontoEnergia();
          ((MoveMundo)getWorld()).removerObjeto(hp);
          ((MoveMundo)getWorld()).removerObjeto(this);
       
            return true;
          }
          else
            return false;
    }
    
    /**
     * Este método é responsável por executar o
     * ataque do ator.
     */
    public void bater(){
        frameAtaque();
    }
    
    /**
     * Este método é responsável por exibir a
     * animação geral do ator.
     */
    public void frame()
    {
        if(frameImage==0)
            atualizaAlturas();
        if((frameImage%10)==0){
            setLocation(getX(), alturaFixa);
            setImage(img[frameImage/10]);}
    
        if(frameImage>=151){
            frameImage=-1;
        }
        frameImage++;
    }
    
    /**
     * Este método é responsável por exibir
     * a animação do ator levantando.
     */
    public void frameLevantado(){
        setImage(img[17]);
    }
    
    /**
     * Este método  é responsável por exibir a
     * animação do ator atacando
     */
    public void frameAtaque(){
        if(posFrameAtaque==10)
            setLocation(getX(),alturaNoAtaque-10);
        if((posFrameAtaque%10==0))
            setLocation(getX(),alturaNoAtaque);
            setImage(imgAtaque[posFrameAtaque/10]);
        
       
            if(posFrameAtaque>=41){
            posFrameAtaque=-1;
            ataqueExecutado=true;
            ataque=false;
        }
        posFrameAtaque++;    
        
    }
    
    /**
     * Este método movimenta a vida do ator
     */
    private void movimentaVida(){
                   hp.setLocation(getX(), getY()-50);
    }
    
    private void atualizaAlturas(){
        this.alturaFixa=getY();
        this.alturaNoAtaque=getY()-15;
    }
    
    /**
     * Este método é responsável por
     * inverter a imagem do ator
     */
    public void inverterImagem()
    {
        for (int x=0; x<img.length;x++)
           img[x].mirrorHorizontally();
       
        for(int x=0; x<imgAtaque.length;x++)
           imgAtaque[x].mirrorHorizontally();
    }
    
    private GreenfootImage[] img ={new GreenfootImage("c0.png"),new GreenfootImage("c1.png"),new GreenfootImage("c2.png"),new GreenfootImage("c3.png"),new GreenfootImage("c4.png"),new GreenfootImage("c5.png"),new GreenfootImage("c6.png"),
    new GreenfootImage("c7.png"),new GreenfootImage("c8.png"),new GreenfootImage("c9.png"),new GreenfootImage("c10.png"),new GreenfootImage("c11.png"),new GreenfootImage("c12.png"),
    new GreenfootImage("c13.png"),new GreenfootImage("c30.png"),
    new GreenfootImage("c31.png")};
    
    private GreenfootImage [] imgAtaque = {new GreenfootImage("c21.png"),new GreenfootImage("c22.png"),new GreenfootImage("c23.png"),
        new GreenfootImage("c24.png"),new GreenfootImage("c25.png")};
    
    private int alturaNoAtaque;
    private int alturaFixa;
    private Actor ob;    
    private boolean ataqueExecutado=false;
    private int direcao=1;
    private int posFrameAtaque;
   
}
    
