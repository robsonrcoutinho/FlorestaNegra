import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o terceiro inimigo,
 * sua principal funcionalidade é
 * exibir sua animação de crescimento.
 * 
 * @since  Novembro, 2013.
 */
public class Inimigo03 extends Inimigos
{
   public Inimigo03(){
       setAlturaPadrao(33);
   }
    
   /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */ 
    public void act() 
    {
        if(parar==false){
            frame();
            levouDano();
        }else{
            levouDano();
            colisao();
        }
    } 
    
    public void levouDano(){
        if(dano==true){
               Actor k=((MoveMundo)getWorld()).getPersonagemPrincipal();
           ((Jogador)k).getEnergia().recuperarPontoEnergia();
        
            ((MoveMundo)getWorld()).removerObjeto(this);
        }
    }
    
    /**
     *  Este método exibe a animação do ator
     *  e posiciona ele em relação ao mundo
     */
    private void frame(){
        if(frameImage%10==0)
            setImage(image[frameImage/10]);
        if(frameImage==140){
            setLocation(getX(), getY()-1);
        }if(frameImage==150){
            setLocation(getX(), getY()-1);
        }if(frameImage==160){
            setLocation(getX(), getY()-1);
        }if(frameImage==170){
            setLocation(getX(), getY()-4);
        }if(frameImage==180){
             setLocation(getX(), getY()-4);
        }if(frameImage==190){
            setLocation(getX(), getY()-4);
        }
        if(frameImage==200){
            setLocation(getX(), getY()-4);
        }
        if(frameImage==450){
            setLocation(getX(), getY()+3);
        }if(frameImage==460){
            setLocation(getX(), getY()+7);
        }if(frameImage==470){
            setLocation(getX(), getY()+9);
        }
        if(frameImage==521){
           frameImage=-1;       }
        frameImage++;   
    }
    
        private GreenfootImage[] image = { new GreenfootImage("q0.png"),new GreenfootImage("q1.png"),new GreenfootImage("q2.png"),new GreenfootImage("q3.png"),
        new GreenfootImage("q4.png"),new GreenfootImage("q5.png"),new GreenfootImage("q6.png"),new GreenfootImage("q7.png"),new GreenfootImage("q8.png"),
        new GreenfootImage("q9.png"),new GreenfootImage("q10.png"),new GreenfootImage("q11.png"),new GreenfootImage("q12.png"),new GreenfootImage("q13.png"),
        new GreenfootImage("q14.png"),new GreenfootImage("q15.png"),new GreenfootImage("q16.png"),new GreenfootImage("q7.png"),new GreenfootImage("q18.png"),
        new GreenfootImage("q19.png"),new GreenfootImage("q20.png"),new GreenfootImage("q21.png"),new GreenfootImage("q22.png"),new GreenfootImage("q23.png"),
        new GreenfootImage("q24.png"),new GreenfootImage("q25.png"),new GreenfootImage("q26.png"),new GreenfootImage("q27.png"),new GreenfootImage("q28.png"),
        new GreenfootImage("q29.png"),new GreenfootImage("q30.png"),new GreenfootImage("q31.png"),new GreenfootImage("q32.png"),new GreenfootImage("q33.png"),
        new GreenfootImage("q34.png"),new GreenfootImage("q35.png"),new GreenfootImage("q36.png"),new GreenfootImage("q37.png"),new GreenfootImage("q38.png"),
        new GreenfootImage("q39.png"),new GreenfootImage("q40.png"),new GreenfootImage("q41.png"),new GreenfootImage("q42.png"),new GreenfootImage("q43.png"),
        new GreenfootImage("q44.png"),new GreenfootImage("q45.png"),new GreenfootImage("q46.png"),new GreenfootImage("q47.png"),new GreenfootImage("q48.png"),
        new GreenfootImage("q49.png"),new GreenfootImage("q50.png"),new GreenfootImage("q51.png"),new GreenfootImage("q52.png")};
       
}
  