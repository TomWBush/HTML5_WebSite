/**
 * GEColorMap.java
 * Author: ErhFang Lee
 * LONI UCLA
 */
package edu.ucla.loni.LOVE.colormap.plugins;

import edu.ucla.loni.LOVE.colormap.ColorMap;

import java.lang.String;

/**
 * This is a GE colormap
 */
public class GEColorMap extends ColorMap
{
    // Spectral ColorMap lookup table defined in JIV
    private static final double[][] ge_specification = {
        {  1, 0.0000 , 0.0000 , 0.0000 },
        {  2, 0.0000 , 0.0321 , 0.0314 },
        {  3, 0.0000 , 0.0643 , 0.0627 },
        {  4, 0.0000 , 0.0964 , 0.0941 },
        {  5, 0.0000 , 0.1325 , 0.1255 },
        {  6, 0.0000 , 0.1647 , 0.1569 },
        {  7, 0.0000 , 0.1968 , 0.1882 },
        {  8, 0.0000 , 0.2289 , 0.2196 },
        {  9, 0.0000 , 0.2610 , 0.2510 },
        { 10, 0.0000 , 0.2932 , 0.2824 },
        { 11, 0.0000 , 0.3253 , 0.3137 },
        { 12, 0.0000 , 0.3574 , 0.3451 },
        { 13, 0.0000 , 0.3936 , 0.3765 },
        { 14, 0.0000 , 0.4257 , 0.4078 },
        { 15, 0.0000 , 0.4578 , 0.4392 },
        { 16, 0.0000 , 0.4900 , 0.4706 },
        { 17, 0.0078 , 0.5060 , 0.5020 },
        { 18, 0.0392 , 0.4739 , 0.5294 },
        { 19, 0.0706 , 0.4418 , 0.5608 },
        { 20, 0.1020 , 0.4096 , 0.5922 },
        { 21, 0.1333 , 0.3815 , 0.6235 },
        { 22, 0.1647 , 0.3494 , 0.6549 },
        { 23, 0.1922 , 0.3173 , 0.6863 },
        { 24, 0.2235 , 0.2851 , 0.7176 },
        { 25, 0.2549 , 0.2530 , 0.7490 },
        { 26, 0.2863 , 0.2209 , 0.7804 },
        { 27, 0.3176 , 0.1888 , 0.8118 },
        { 28, 0.3490 , 0.1566 , 0.8431 },
        { 29, 0.3804 , 0.1285 , 0.8745 },
        { 30, 0.4118 , 0.0964 , 0.9059 },
        { 31, 0.4431 , 0.0643 , 0.9373 },
        { 32, 0.4745 , 0.0321 , 0.9686 },
        { 33, 0.5020 , 0.0000 , 1.0000 },
        { 34, 0.5333 , 0.0321 , 0.9373 },
        { 35, 0.5647 , 0.0643 , 0.8745 },
        { 36, 0.5961 , 0.0964 , 0.8118 },
        { 37, 0.6275 , 0.1285 , 0.7490 },
        { 38, 0.6588 , 0.1606 , 0.6863 },
        { 39, 0.6902 , 0.1928 , 0.6235 },
        { 40, 0.7216 , 0.2249 , 0.5608 },
        { 41, 0.7529 , 0.2570 , 0.5020 },
        { 42, 0.7843 , 0.2892 , 0.4392 },
        { 43, 0.8157 , 0.3213 , 0.3765 },
        { 44, 0.8431 , 0.3534 , 0.3137 },
        { 45, 0.8745 , 0.3855 , 0.2510 },
        { 46, 0.9059 , 0.4177 , 0.1882 },
        { 47, 0.9373 , 0.4498 , 0.1255 },
        { 48, 0.9686 , 0.4819 , 0.0627 },
        { 49, 1.0000 , 0.5181 , 0.0000 },
        { 50, 1.0000 , 0.5502 , 0.0627 },
        { 51, 1.0000 , 0.5823 , 0.1255 },
        { 52, 1.0000 , 0.6145 , 0.1922 },
        { 53, 1.0000 , 0.6466 , 0.2549 },
        { 54, 1.0000 , 0.6787 , 0.3176 },
        { 55, 1.0000 , 0.7108 , 0.3804 },
        { 56, 1.0000 , 0.7430 , 0.4431 },
        { 57, 1.0000 , 0.7751 , 0.5098 },
        { 58, 1.0000 , 0.8072 , 0.5725 },
        { 59, 1.0000 , 0.8394 , 0.6353 },
        { 60, 1.0000 , 0.8715 , 0.6980 },
        { 61, 1.0000 , 0.9036 , 0.7608 },
        { 62, 1.0000 , 0.9357 , 0.8235 },
        { 63, 1.0000 , 0.9679 , 0.8902 }

    };

    /**
     * Default constructor
     */
    public GEColorMap(){}

    /**
     * Constructor
     */
    public GEColorMap(int size, int bits) {
        super(size, bits);
    }

    /**
     * Get the names of the current map
     */
    public String getName() {
        return ("GE Colormap");
    }


    protected void _setColorMap() {
        int[] components= new int[ 3];
        int last_ge = ge_specification.length - 1;
        final double step= 1.0 / last_ge;

        for (int pixel = _lowerLimit ; pixel <= _upperLimit; pixel++) {


            // Pixel is on the linear ramp

            if( _upperLimit == pixel) {
                for( int i= 0; i < 3; i++)
                    components[ i]=
                    (int)Math.round(255 * ge_specification[ last_ge][ i+1]);
            }
            else {
                double fraction= (pixel- _lowerLimit) / (double)(_upperLimit - _lowerLimit );
                int interval= (int)Math.floor( fraction / step);
                // we're in: [ interval , interval+1 )
                double interpolator= (fraction - interval*step) / step; // [0,1)
                for( int i= 0; i < 3; i++)
                    components[ i]=
                    (int)Math.round( 255 *
                    (ge_specification[ interval][ i+1] *
                    (1.0-interpolator)
                    +
                    ge_specification[ interval+1][ i+1] *
                    interpolator
                    )
                    );
            }

            _rMap[pixel] = (byte)components[ 0];
            _gMap[pixel] = (byte)components[ 1];
            _bMap[pixel] = (byte)components[ 2];

        }
    }



}


