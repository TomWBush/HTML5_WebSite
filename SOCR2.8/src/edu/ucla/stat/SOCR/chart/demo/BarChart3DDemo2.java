/****************************************************
Statistics Online Computational Resource (SOCR)
http://www.StatisticsResource.org
 
All SOCR programs, materials, tools and resources are developed by and freely disseminated to the entire community.
Users may revise, extend, redistribute, modify under the terms of the Lesser GNU General Public License
as published by the Open Source Initiative http://opensource.org/licenses/. All efforts should be made to develop and distribute
factually correct, useful, portable and extensible resource all available in all digital formats for free over the Internet.
 
SOCR resources are distributed in the hope that they will be useful, but without
any warranty; without any explicit, implicit or implied warranty for merchantability or
fitness for a particular purpose. See the GNU Lesser General Public License for
more details see http://opensource.org/licenses/lgpl-license.php.
 
http://www.SOCR.ucla.edu
http://wiki.stat.ucla.edu/socr
 It s Online, Therefore, It Exists! 
****************************************************/

package edu.ucla.stat.SOCR.chart.demo;
import java.beans.PropertyChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import edu.ucla.stat.SOCR.chart.ChartGenerator_JTable;
import edu.ucla.stat.SOCR.chart.SuperCategoryChart_Bar3D;
import edu.ucla.stat.SOCR.chart.gui.SOCRCategorySeriesLabelGenerator;

/**
 * A simple demonstration application showing how to create a horizontal 3D bar chart using data
 * from a {@link CategoryDataset}.
 */
public class BarChart3DDemo2 extends SuperCategoryChart_Bar3D implements PropertyChangeListener {
	
	public void doTest(){
		 JFreeChart chart;
		 ChartGenerator_JTable chartMaker = new ChartGenerator_JTable();
		 
		 resetChart();
		 showMessageDialog(chartTitle+" doTest get called!");
		
		 int no_series = dataTable.getRowCount()-1;
		 int no_category = dataTable.getColumnCount()-2;
		 int[][] pairs = new int[no_category][2];
		 for (int i=0; i<no_category; i++){
			 pairs[i][0] = i+1;    //column i store category i
			 pairs[i][1] = 0;    //column 0 stores series name
		 }
		 chart = chartMaker.getCategoryChart("Bar", chartTitle, "Category", "value", dataTable, no_category, pairs, "3D horizontal");	
		 chartPanel = new ChartPanel(chart, false); 
			
		 setChart();
	 }
 
    /**
     * Creates a sample dataset.
     * @param   isDemo true use demo data, false use dataTable as input
     * @return A sample dataset.
     */
    protected CategoryDataset createDataset(boolean isDemo) {
		if (isDemo){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(23.0, "Series 1", "London");
        dataset.addValue(14.0, "Series 1", "New York");
        dataset.addValue(14.0, "Series 1", "Istanbul");
        dataset.addValue(14.0, "Series 1", "Cairo");
        dataset.addValue(13.0, "Series 2", "London");
        dataset.addValue(19.0, "Series 2", "New York");
        dataset.addValue(19.0, "Series 2", "Istanbul");
        dataset.addValue(19.0, "Series 2", "Cairo");
        dataset.addValue(7.0, "Series 3", "London");
        dataset.addValue(9.0, "Series 3", "New York");
        dataset.addValue(9.0, "Series 3", "Istanbul");
        dataset.addValue(9.0, "Series 3", "Cairo");
        return dataset;}
		else return super.createDataset(false);
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    protected JFreeChart createChart(CategoryDataset dataset) {
        
        JFreeChart chart = ChartFactory.createBarChart3D(
            chartTitle,       // chart title
            domainLabel,                  // domain axis label
            rangeLabel,                     // range axis label
            dataset,                     // data
            PlotOrientation.HORIZONTAL,  // orientation
            !legendPanelOn,                        // include legend
            true,                        // tooltips
            false                        // urls
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(1.0f);

        // left align the category labels...
        CategoryAxis axis = plot.getDomainAxis();
        CategoryLabelPositions p = axis.getCategoryLabelPositions();
        
        CategoryLabelPosition left = new CategoryLabelPosition(
            RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, 
            TextAnchor.CENTER_LEFT, 0.0,
            CategoryLabelWidthType.RANGE, 0.30f
        );
        axis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(p, left));
        
        BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
		renderer.setLegendItemLabelGenerator(new SOCRCategorySeriesLabelGenerator());
		setCategorySummary(dataset);
        return chart;        
    
    }
    

}
