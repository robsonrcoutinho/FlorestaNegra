import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este classe é referente a flora o primeiro chefão,
 * ela possui diversas ações, dentre essas as principais são,
 * realizar o conjunto de ataques(animações e ataques), 
 * realizar a animação levando dano.
 * 
 * @since Novembro, 2013.
 */
public class Flora extends Chefoes
{
    /**
     * No construtor desse objeto é criado
     * a vida;
     */
    public Flora(){
        hp = new VidaFlora();
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
        redimensionaImagem();
        inverterImagem();
        setImage(img[0]);
        coracao.setVolume(100);
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        if(passo1Completo==false){
            if(repeticoesFrame!=3){
                    frame();
            }else{
                coracao.stop();
              if(execucaoFrame2!=1)
                    frame2();
            }
        }
        else{
            if(!morreu()){
                if(frameLevouDanoCompleto==true){
                    levouDano();
                    if(frameExibidoInicio==false)
                        frameExibidoInicio=frame3();
                    else{
                        if(vezAtaque1==true)
                             conjunto(1);
                        if(vezAtaque2==true)
                             conjunto(2);     
                        if(vezAtaque3==true)
                             conjunto(3);
                    }
                }else{
                    frameLevouDano();
                }   
          }else
            if(frameMorrendoCompleto==false)
                 frameMorrendo();
        }
    }
    
    /**
     * Este método verifica
     * se o ator morreu,
     * caso tenha morrido ele remove
     * a vida e o ator do cenário.
     * @return boolean - true caso o personagem tenha morrido, do contrário retorna false.
     */
    private boolean morreu()
    {
      if(hp.getPontoVida()<=0)
      {
        getWorld().removeObject(hp);
        return true;
      }
      else{
        return false;
      }
    }
    
    /**
     * Este método é responsável por
     * exibir a primeria animção
     */
    private void frame(){
        coracao.playLoop();
        if(posFrame%20==0)
            setImage(img[posFrame/20]);
        
        if(posFrame==181){
            posFrame=-1;
            repeticoesFrame++;
        }
            posFrame++;    
    }
    
    
    /**
     * Este mpetodo é responsável por exibir
     * a segunda animação do ator,
     * e logo apoós adicionar a vida ao mundo.
     */
    private void frame2(){
        if(posFrame2%10==0)
            setImage(segundoFrame[posFrame2/10]);
        
        if(posFrame2==681){
            posFrame2=-1;
            execucaoFrame2++;
            passo1Completo=true;
            getWorld().addObject(hp, getX(), getY()-200);    
            this.dano=false;
        }
        posFrame2++;    
    }
    
    private void frameMorrendo(){
     if(posFrameMorrendo%10==0)
        setImage(segundoFrame[posFrameMorrendo/10]);
     
     if(posFrameMorrendo==610){
        frameMorrendoCompleto=true;
     }
        posFrameMorrendo--;   
    }
    
    /**
     * Este método é responsável por exibir
     * a animação intermediária entre os ataques
     * @return boolean - true se o frame foi executado completamente, do contrário retorna false.
     */
    private boolean frame3(){
        if(posFrame3%20==0)
            setImage(terceiroFrame[posFrame3/20]);
        
        if(posFrame3==281){
            posFrame3=-1;
            return true;
        }else{
            posFrame3++;
            return false;
        }
    }
    
    /**
     * Este método verifica se o ator
     * levou dano, caso tenha levado,
     * ele perder 1 ponto de vida, e
     * exibe aciona o frame do ator levando dano
     * através do boolean frameLevouDanoCompleto
     */
    public void levouDano()
    {
        if(dano==true){
            hp.perderPontoVida();
            dano=false;
            frameLevouDanoCompleto=false;
        }
        if(dano2==true){
            for(int x=0;x<valorDano2Padrao;x++){
                hp.perderPontoVida();
                if(hp.getPontoVida()==0)
                    break;
            }
            dano2=false;
            frameLevouDanoCompleto=false;
        }
    }
    
    /**
     * Este método é responsável
     * por exibir a animação do ataque 1.
     */
    private void frameAtaque1(){
        if(posFrameAtaque1%10==0)
            setImage(frameAtaque1[posFrameAtaque1/10]);
            
        if(posFrameAtaque1==31){
             posFrameAtaque1=-1;
             frameAtaque1Completo=true;
             ataque1EmAndamento=true;
        }
       
        posFrameAtaque1++;       
    }
    
    /**
     * Este mpetodo adiciona o 
     * ataque 1 ao mundo.
     */
    private void ataque1(){
       getWorld().addObject(new Ataque1Flora(1), getX()-200, getY()+150);
       
       if(contadorDoAtaque1==10){
            ataque1EmAndamento=false;
       }
       
       if(contadorDoAtaque1==10)
            contadorDoAtaque1=-1;
       
            contadorDoAtaque1++;
    }
    
    /**
     * Este método é responsável
     * por exibir a animação
     * referente ao ataque 2.
     */
    private void frameAtaque2(){
        if(posFrameAtaque2%10==0)
             setImage(frameAtaque2[posFrameAtaque2/10]);
            
        if(posFrameAtaque2==11){
             posFrameAtaque2=-1;
             frameAtaque2Completo=true;
             ataque2EmAndamento=true;
        }
       
        posFrameAtaque2++; 
    }
    
    /**
     * Este método é responsável por
     * adicionar ao mundo o ataque 2.
     */
    private void ataque2(){
        getWorld().addObject(new Ataque2Flora(2), getX()-137, getY()-63);
        getWorld().addObject(new Ataque2Flora(2), getX()+60, getY()-97);
        ataque2EmAndamento=false;
    }
    
    /**
     * Este método é responsável pela animação do ataque 3.
     */
    private void frameAtaque3(){
       if(posFrameAtaque3%10==0)
            setImage(frameAtaque3[posFrameAtaque3/10]);
            
        if(posFrameAtaque3==21){
             posFrameAtaque3=-1;
             frameAtaque3Completo=true;
             ataque3EmAndamento=true;
        }
        posFrameAtaque3++; 
    }
    
    /**
     * Este método adiciona ao mundo o ataque 3.
     */
    private void ataque3(){
        getWorld().addObject(new Ataque3Flora(2), getX()-137, getY()-63);
        ataque3EmAndamento=false;
    }
    
    /**
     * Esté método aciona conjuntos de métodos
     * ex: Verifica se é a vez do ataque 1
     * Exibe a animação do ataque 1, após a conclusão
     * ele libera o ataque 1.
     * @param ataque - desencadeia a sequencia de passos para reaizar determinado ataque
     */
    private void conjunto(int ataque){
        if(ataque==1){
           if(frameAtaque1Completo==false)    
                frameAtaque1();
                else{
                    if(ataque1EmAndamento==true)
                        ataque1();
                    else{
                       frameExibido1=frame3();
                    if(frameExibido1==true){
                        vezAtaque1=false;
                        vezAtaque2=true;
                    }
                }
            }
       }
      
      if(ataque==2){
          if(frameAtaque2Completo==false)    
                frameAtaque2();
                else{
                    if(ataque2EmAndamento==true)
                        ataque2();
                    else{
                        frameExibido2=frame3();
                    if(frameExibido2==true){
                        vezAtaque2=false;
                        vezAtaque3=true;
                    }
                   }
                }
      }
      
      if(ataque==3){
          if(frameAtaque3Completo==false)    
                frameAtaque3();
                else{
                    if(ataque3EmAndamento==true)
                        ataque3();
                    else{
                        frameExibido3=frame3();
                    if(frameExibido3==true){
                            vezAtaque3=false;
                            frameAtaque1Completo=false;
                            frameAtaque2Completo=false;
                            frameAtaque3Completo=false;
                            vezAtaque1=true;
                    }
                }
          }
      } 
    }
   
    /**
     * Este método é responsável por exibir
     * a animação do ator levando dano
     */
    private void frameLevouDano(){
       if(posFrameLevouDano%10==0)
            setImage(frameLevouDano[posFrameLevouDano/10]);
       
       if(posFrameLevouDano==11){
            posFrameLevouDano=-1;
            frameLevouDanoCompleto=true;
       }
           
            posFrameLevouDano++;
    }
    
   /**
    * Este método redimensiona a imagem do ator
    * para 400,600
    */
    private void redimensionaImagem()
    {
        for (int x=0; x<img.length;x++)
            img[x].scale(400, 460);
            
        for (int x=0; x<segundoFrame.length;x++)
           segundoFrame[x].scale(400, 460);    
        
        for (int x=0; x<terceiroFrame.length;x++)
            terceiroFrame[x].scale(400, 460);
        
        for (int x=0; x<frameAtaque1.length;x++)
            frameAtaque1[x].scale(400, 460);
        
        for (int x=0; x<frameAtaque2.length;x++)
            frameAtaque2[x].scale(400, 460);
        
        for (int x=0; x<frameAtaque3.length;x++)
            frameAtaque3[x].scale(400, 460);
      
        for (int x=0; x<frameLevouDano.length;x++)
            frameLevouDano[x].scale(400, 460);
      
        }
    
    /**
     * Este método inverter a imagem do ator
     * na horizontal
     */    
    private void inverterImagem(){
        for (int x=0; x<img.length;x++)
            img[x].mirrorHorizontally();
    
        for (int x=0; x<segundoFrame.length;x++)
           segundoFrame[x].mirrorHorizontally();    
        
        for (int x=0; x<terceiroFrame.length;x++)
            terceiroFrame[x].mirrorHorizontally();
        
       for (int x=0; x<frameAtaque1.length;x++)
            frameAtaque1[x].mirrorHorizontally();
       
       for (int x=0; x<frameAtaque2.length;x++)
            frameAtaque2[x].mirrorHorizontally();
       
       for (int x=0; x<frameAtaque3.length;x++)
            frameAtaque3[x].mirrorHorizontally();
       
       for (int x=0; x<frameLevouDano.length;x++)
            frameLevouDano[x].mirrorHorizontally();
       
    }
   
    public boolean getPasso1Completo(){
        return this.passo1Completo;
    }
    
    public boolean getFrameMorrendoCompleto(){
        return this.frameMorrendoCompleto;
    }
   
    private GreenfootImage [] img = {new GreenfootImage("cf0.png"),new GreenfootImage("cf1.png"),new GreenfootImage("cf2.png"),new GreenfootImage("cf3.png"),
    new GreenfootImage("cf4.png"),new GreenfootImage("cf5.png"),    new GreenfootImage("cf6.png"),new GreenfootImage("cf7.png"),new GreenfootImage("cf8.png"),new GreenfootImage("cf9.png")};
    
    private GreenfootImage []segundoFrame ={new GreenfootImage("cf10.png"),new GreenfootImage("cf11.png"),new GreenfootImage("cf12.png"),new GreenfootImage("cf13.png"),
    new GreenfootImage("cf14.png"),new GreenfootImage("cf15.png"),new GreenfootImage("cf16.png"),new GreenfootImage("cf17.png"),new GreenfootImage("cf18.png"),new GreenfootImage("cf19.png"),
    new GreenfootImage("cf20.png"),new GreenfootImage("cf21.png"),new GreenfootImage("cf22.png"),new GreenfootImage("cf23.png"),new GreenfootImage("cf24.png"),new GreenfootImage("cf25.png"),
    new GreenfootImage("cf26.png"),new GreenfootImage("cf27.png"),new GreenfootImage("cf28.png"),new GreenfootImage("cf29.png"),new GreenfootImage("cf30.png"),new GreenfootImage("cf31.png"),
    new GreenfootImage("cf32.png"),new GreenfootImage("cf33.png"),new GreenfootImage("cf34.png"),new GreenfootImage("cf35.png"),new GreenfootImage("cf36.png"),new GreenfootImage("cf37.png"),
    new GreenfootImage("cf38.png"),new GreenfootImage("cf39.png"),new GreenfootImage("cf40.png"),new GreenfootImage("cf41.png"),new GreenfootImage("cf42.png"),new GreenfootImage("cf43.png"),
    new GreenfootImage("cf44.png"),new GreenfootImage("cf45.png"),new GreenfootImage("cf46.png"),new GreenfootImage("cf47.png"),new GreenfootImage("cf48.png"),new GreenfootImage("cf49.png"),
    new GreenfootImage("cf50.png"),new GreenfootImage("cf51.png"),new GreenfootImage("cf52.png"),new GreenfootImage("cf53.png"),new GreenfootImage("cf54.png"),new GreenfootImage("cf55.png"),
    new GreenfootImage("cf56.png"),new GreenfootImage("cf57.png"),new GreenfootImage("cf58.png"),new GreenfootImage("cf59.png"),new GreenfootImage("cf60.png"),new GreenfootImage("cf61.png"),
    new GreenfootImage("cf62.png"),new GreenfootImage("cf63.png"),new GreenfootImage("cf64.png"),new GreenfootImage("cf65.png"),new GreenfootImage("cf66.png"),
    new GreenfootImage("cf67.png"),new GreenfootImage("cf68.png"),new GreenfootImage("cf69.png"),new GreenfootImage("cf70.png"),new GreenfootImage("cf71.png"),
    new GreenfootImage("cf72.png"),new GreenfootImage("cf73.png"),new GreenfootImage("cf74.png"),new GreenfootImage("cf75.png"),new GreenfootImage("cf76.png"),
    new GreenfootImage("cf77.png"),new GreenfootImage("cf78.png")};
    
    private GreenfootImage[] terceiroFrame ={new GreenfootImage("cf79.png"),new GreenfootImage("cf80.png"),new GreenfootImage("cf81.png"),
    new GreenfootImage("cf82.png"),new GreenfootImage("cf83.png"),new GreenfootImage("cf89.png"),new GreenfootImage("cf90.png"),new GreenfootImage("cf91.png"),
    new GreenfootImage("cf92.png"),new GreenfootImage("cf93.png"),new GreenfootImage("cf98.png"),new GreenfootImage("cf99.png"),new GreenfootImage("cf100.png"),new GreenfootImage("cf101.png"),
    new GreenfootImage("cf102.png")};
    
    private GreenfootImage[] frameLevouDano ={new GreenfootImage("cf87.png"),new GreenfootImage("cf88.png")};
    
    private GreenfootImage[] frameAtaque1 ={new GreenfootImage("cf94.png"),new GreenfootImage("cf95.png"),new GreenfootImage("cf96.png"),
    new GreenfootImage("cf97.png")};
    private GreenfootImage[] frameAtaque2 ={new GreenfootImage("cf103.png"),new GreenfootImage("cf104.png")};
    private GreenfootImage[] frameAtaque3 ={new GreenfootImage("cf84.png"),new GreenfootImage("cf85.png"),new GreenfootImage("cf86.png")};
    
    private int repeticoesFrame=0;
    private int execucaoFrame2=0;
    private int posFrame2=0;
    private int posFrame3;
    private int execucaoFrame3;
    
    private int posFrameAtaque1=0;
    private int posFrameAtaque2=0;
    private int posFrameAtaque3=0;
    private int posFrameLevouDano=0;
    private int posFrameMorrendo=680;
    
    private boolean ataque1EmAndamento;
    private boolean frameAtaque1Completo; 
    private boolean ataque2EmAndamento;
    private boolean frameAtaque2Completo;
    private boolean ataque3EmAndamento;
    private boolean frameAtaque3Completo;
    private boolean frameLevouDanoCompleto=true;
    private boolean frameMorrendoCompleto=false;
    
    private int contadorDoAtaque1;
    
    private VidaFlora hp;
    private int direcao=1;
    private int tempoEsperado;
    private boolean vezAtaque1=true;  
    private boolean vezAtaque2;
    private  boolean vezAtaque3;
    private boolean frameExibidoInicio;
    private boolean frameExibido1;
    private boolean frameExibido2;
    private boolean frameExibido3;
    private boolean passo1Completo=false;
    GreenfootSound coracao = new GreenfootSound("coracao.mp3");
}
