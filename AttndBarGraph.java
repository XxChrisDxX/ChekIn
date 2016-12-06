import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class AttndBarGraph extends JPanel {
	private static final int PREF_W = 800;
	private static final int PREF_H = 650;
	private static final int BORDER_GAP = 60;
	private static final Color GRAPH_COLOR = Color.blue;
	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private static final int GRAPH_POINT_WIDTH = 12;
	private ArrayList<Double> attend = new ArrayList<Double>();// y axis count
	private String[] date;// x axis age labels
	private static int size; // gives x count for axis
	private static int max; // gives y height for count
	private int Y_HATCH_CNT;
	private String[] avgage;
	private String title;

	public AttndBarGraph(String title, int max, int size, double[][] data,
			String[] date) {
		this.size = size;
		this.title = title;
		this.max = max;
		Y_HATCH_CNT = max;
		avgage = new String[size];
		for (int i = 0; i < size; i++) {
			attend.add(data[0][i]);
			avgage[i] = String.format("%.2f", data[1][i]);
		}
		this.date = date;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (size);
		double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (max);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < size; i++) {
			int x1 = (int) ((i + 1) * xScale + BORDER_GAP);
			int y1 = (int) ((max - attend.get(i)) * yScale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}

		// create x and y axes
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP,
				BORDER_GAP);
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth()
				- BORDER_GAP, getHeight() - BORDER_GAP);

		g2.drawString("Attendance", BORDER_GAP - 15, BORDER_GAP - 15);
		if (title.equals("All Events")) {
			g2.drawString("Event Type", (getWidth() - BORDER_GAP) / 2,
					(getHeight() - BORDER_GAP + 47));
		} else {
			g2.drawString("Date", (getWidth() - BORDER_GAP) / 2, (getHeight()
					- BORDER_GAP + 47));
		}

		// create hatch marks for y axis.
		for (int i = 0; i < Y_HATCH_CNT; i++) {
			int x0 = BORDER_GAP;
			int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
			int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2))
					/ Y_HATCH_CNT + BORDER_GAP);
			int y1 = y0;
			g2.drawLine(x0, y0, x1, y1);
		}

		// and for x axis
		for (int i = 0; i < size; i++) {
			int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (size)
					+ BORDER_GAP;
			int x1 = x0;
			int y0 = getHeight() - BORDER_GAP;
			int y1 = y0 - GRAPH_POINT_WIDTH;
			g2.drawLine(x0, y0, x1, y1);
		}

		// for y axis labels
		for (int i = 1; i <= Y_HATCH_CNT; i++) {
			int x0 = BORDER_GAP - 37;
			int y0 = getHeight() - (((i) * (getHeight() - BORDER_GAP * 2))
					/ Y_HATCH_CNT + BORDER_GAP) + 7;
			String label = "" + i;
			g2.drawString(label, x0, y0);
		}

		// for x axis labels
		for (int i = 0; i < size; i++) {
			int y0 = getHeight() - BORDER_GAP;
			int xlabel = (i + 1) * (getWidth() - BORDER_GAP * 2) / (size)
					+ BORDER_GAP;
			g2.drawString(date[i], xlabel - 27, y0 + 20);

		}

		g2.drawString("*Number above bars indicates average age*", ((getWidth()
				- BORDER_GAP) / 2) + 150, BORDER_GAP - 40);

		Stroke oldStroke = g2.getStroke();
		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x1 = graphPoints.get(i).x - 10;
			int y1 = graphPoints.get(i).y;
			int x2 = 20;
			int y2 = getHeight() - BORDER_GAP - y1;
			g2.fillRect(x1, y1, x2, y2);
			g2.drawString(avgage[i], x1 - 7, y1 - 10);
		}
		g2.setColor(Color.red);
		g2.drawString(title, (getWidth() - BORDER_GAP) / 2, BORDER_GAP - 40);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}
}