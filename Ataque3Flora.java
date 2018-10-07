import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o terceiro ataque de flora,
 * suas principais ações são, mover-se
 * no eixo Y, e caso acertar o personagem principal,
 * lhe dar dano.
 * @since Novembro, 2013.
 */
public class Ataque3Flora extends TiroInimigos
{
    /**
     * No construtor é setado
     * a direção no qual o ator 
     * deve seguir
     * @param direcao - direção do ator.
     */
    public Ataque3Flora(int direcao){
        this.direcao=direcao;
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido no mundo.
     * a imagem dele é escalada;
     * @param world
     */
    protected void addedToWorld(World world){
        img.scale(70,500);
        setImage(img);
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */

    public void act() 
    {
        if(miraTravada!=true)
            mira();
        else{
            //if(atrasaDescida%2==0){
            move2();
            colisao();
        //}
        //if(atrasaDescida==200)
          //  atrasaDescida=-1;
        //atrasaDescida++;
       }
    }    
    
    /**
     * Este metodo obtem a posição de oberon
     * e posiona o ator na mesma cordenada X,
     * e acima de Oberon
     */
    public void mira(){
        posOberon=((Apocalipse)getWorld()).getPersonagemPrincipal();
        setLocation(posOberon.getX(), getY()-220);
        miraTravada=true;
    }
    
    private int atrasaDescida;
    private GreenfootImage img = new GreenfootImage("cfat1.png");
    private Actor posOberon;
    private boolean miraTravada;
}
