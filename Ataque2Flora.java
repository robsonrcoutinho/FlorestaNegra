import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o segundo ataque do chefão flora,
 * suas principais funcionalidades são,
 * mover-se nos dois eixos X e Y afim de chocar-se
 * com o personagem Principal, caso acerte ele
 * efetua danos no personagem.
 *
 * @since Novembro,2013.
 */
public class Ataque2Flora extends TiroInimigos
{
    /**
     * Esse construtor recebe um int como parâmetro,
     * representando a possivel direção na qual o ator
     * deve seguir.
     * @param direcao - direcao na qual o ator deve seguir.
     */
    public Ataque2Flora(int direcao){
        this.direcao=direcao;
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
        img.mirrorHorizontally();
        img.scale(20,20);
        setImage(img);
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        if(isTouching(Espada.class)){
               Actor ob=((Apocalipse)getWorld()).getPersonagemPrincipal();
               
               if(ob!=null)
                    ((Jogador)ob).getEnergia().recuperarPontoEnergia();
                    
               ((Apocalipse)getWorld()).removerObjeto(this);
        }else{
            if(miraTravada==false){
                mira();
            }else{
                calculaDistanciaMaior();    
                if(distanciaX>distanciaY){
                    maior=distanciaX/distanciaY;
                    maior*=2;  
                    if(getX()>posOberonX)
                         setLocation(getX()-maior, getY());
                    if(getX()<posOberonX)
                         setLocation(getX()+maior, getY());
                    if(getY()<posOberonY)
                         setLocation(getX(), getY()+2);
                    if(getY()>posOberonY)
                         setLocation(getX(), getY()-2);
                }
    
                if(distanciaX<distanciaY){
                    maior=distanciaY/distanciaX;
                    maior*=2;
                    if(getX()>=posOberonX)
                        setLocation(getX()-2, getY());
                    if(getX()<=posOberonX)
                        setLocation(getX()+2, getY());
                    if(getY()<=posOberonY)
                        setLocation(getX(), getY()+maior);
                    if(getY()>=posOberonY)
                        setLocation(getX(), getY()-maior);
                
                    }
                
                if(distanciaX==distanciaY){      
                     if(getX()>=posOberonX)
                         setLocation(getX()-2, getY());
                     if(getX()<=posOberonX)
                         setLocation(getX()+2, getY());
                     if(getY()<=posOberonY)
                         setLocation(getX(), getY()+2);
                     if(getY()>=posOberonY)
                          setLocation(getX(), getY()-2);
                            }
                    colisao();
              }
        }
    }        
    
    /**
     * Este método configura as variáveis posOberonX e posOberonY
     * com as cordenadas do ator Oberon.
     */
    public void mira(){
        posOberonX=((Apocalipse)getWorld()).getPersonagemPrincipal().getX();
        posOberonY=((Apocalipse)getWorld()).getPersonagemPrincipal().getY();
        miraTravada=true;
    }
    
    /**
     * Este método seta as cordenadas X e Y,
     * em relação a distância do ator e da base.
     */
    public void calculaDistanciaMaior(){
       distanciaY=getWorld().getHeight()-getY();
       distanciaX=getX()-posOberonX;
    }
    
    private int distanciaY;
    private int distanciaX;
    private int posOberonX;
    private int posOberonY;
    private int maior=1;
    private boolean miraTravada;
    private GreenfootImage img = new GreenfootImage("cfat9.png"); 
}
