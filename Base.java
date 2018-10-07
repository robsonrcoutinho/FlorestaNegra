import greenfoot.*;

/**
 * Esta classe é referente a base de chão
 * do mundo.
 * since Novembro 2013.
 */
public class Base extends Actor
{
    /**
     * O constutor recbee três parâmetros,
     * dois inteiror referente a altura e lagura do objeto,
     * e a imagem que o objeto usurá.
     * @param width - refere-se a altura do objeto, height altura do objeto e GreenfootImage, tile - a imagem que será setada no objeto.
     */
    public Base(int width, int height, GreenfootImage tile)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for (int rows=0; rows<height; rows+=tile.getHeight()){
            for(int offset=0; offset<width; offset+=tile.getWidth()) image.drawImage(tile, offset, rows);
        }
        setImage(image);
    }
}
