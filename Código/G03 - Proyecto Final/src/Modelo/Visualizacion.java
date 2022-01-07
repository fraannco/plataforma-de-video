
package Modelo;

import Modelo.Video;
import java.io.Serializable;

public class Visualizacion implements Serializable {

    Video video;
    int vecesVisto;

    //CONSTRUCTORES
    public Visualizacion(Video videos) {
        this.video = videos;
        this.vecesVisto = 0;
    }

    public Visualizacion(Video video, int vecesVisto) {
        this.video = video;
        this.vecesVisto = vecesVisto;
    }

    //GETTERS Y SETTERS
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getVecesVisto() {
        return vecesVisto;
    }

    public void setVecesVisto(int vecesVisto) {
        this.vecesVisto = vecesVisto;
    }
    
    public void aumentarVisualizacion(){
        this.vecesVisto ++;
    }
    
    

}
