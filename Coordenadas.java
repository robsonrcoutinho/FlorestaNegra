import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é  uma classe cordenadas
 * ela guarda duas cordenadas no eixo x
 * e y;
 * 
 * @Dezembro 2013.
 */
public class Coordenadas 
{
    /**
     * Nesse construtor é atribuido 
     * as cordenadas x e Y os seus valores padrões.
     */
    public Coordenadas(){
        this.x=padraoX;
        this.y=padraoY;
    }
    
    /**
     * Este construtor recebe dois parâmetros
     * referentes aos eixos X e Y;
     * @param x,y - São referentes as cordenadas no eixo X e Y. 
     */
    public Coordenadas(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * Seta os valores das cordenadas.
     * @paran x,y - São referentes as cordenadas no eixo X e Y.
     */
    public void setCoordenadas(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * Retorna a cordena do eixo X.
     * @return int - referente a cordenada do eixo X.
     */
    public int  getX(){
        return this.x;
    }
    
    /**
     * Retorna a cordenada do eixo Y.
     * @return int - referente a cordenada do eixo Y.
     */
    public int getY(){
        return this.y;
    }

    
    private int x;
    private int y;
    public static final int padraoX=400;
    public static final int padraoY=355;
    
}
