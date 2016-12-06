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
public class LineGraph extends JPanel {
	private static final int PREF_W = 800;
	private static final int PREF_H = 650;
	private static final int BORDER_GAP = 60;
	private static final Color GRAPH_COLOR = Color.green;
	private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private static final int GRAPH_POINT_WIDTH = 12;
	private ArrayList<Double> scores = new ArrayList<Double>();// y axis count
	private String[] age;// x axis age labels
	private static int size; // gives x count for ages
	private static int max; // gives y height for count
	private int Y_HATCH_CNT;
	private String[] count;
	private String title;

	public LineGraph(String title, int size, int max, String[] ages,
			double[] amount) {
		this.size = size;
		this.title = title;
		this.max = max;
		Y_HATCH_CNT = max;
		for (int i = 0; i < amount.length; i++)
			scores.add(amount[i]);
		age = ages;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		double xScale;
		if (size > 1) {
			xScale = ((double) getWidth() - 2 * BORDER_GAP) / (size - 1);
		} else {
			xScale = ((double) getWidth() - 2 * BORDER_GAP) / (size);

		}
		double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (max);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < size; i++) {
			int x1 = (int) (i * xScale + BORDER_GAP);
			int y1 = (int) ((max - scores.get(i)) * yScale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}

		// create x and y axes
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP,
				BORDER_GAP);
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth()
				- BORDER_GAP, getHeight() - BORDER_GAP);

		g2.drawString("Attendance", BORDER_GAP - 15, BORDER_GAP - 15);
		g2.drawString("Ages", (getWidth() - BORDER_GAP) / 2, (getHeight()
				- BORDER_GAP + 47));

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
		if (size > 1) {
			for (int i = 0; i < size - 1; i++) {
				int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (size - 1)
						+ BORDER_GAP;
				int x1 = x0;
				int y0 = getHeight() - BORDER_GAP;
				int y1 = y0 - GRAPH_POINT_WIDTH;
				g2.drawLine(x0, y0, x1, y1);
			}
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
		if (size > 1) {
			for (int i = 0; i < size; i++) {
				int y0 = getHeight() - BORDER_GAP;
				int xlabel = (i) * (getWidth() - BORDER_GAP * 2) / (size - 1)
						+ BORDER_GAP;
				g2.drawString(age[i], xlabel - 10, y0 + 20);
			}
		} else {
			g2.drawString(age[0], BORDER_GAP - 10, getHeight() - BORDER_GAP
					+ 20);
		}

		Stroke oldStroke = g2.getStroke();
		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(GRAPH_POINT_COLOR);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
			;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
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