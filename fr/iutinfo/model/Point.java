package fr.iutinfo.model;

public class Point implements Cloneable {
	private double _top;
	private double _left;
	
	public Point(double top, double left) {
		_top = top;
		_left = left;
	}

	public double getTop() {
		return _top;
	}

	public void setTop(double top) {
		this._top = top;
	}

	public double getLeft() {
		return _left;
	}

	public void setLeft(double left) {
		this._left = left;
	}
	
	public String toString() {
		return "Point("+_left+","+_top+")";
	}	
	
	public Point clone() {
		try {
			return (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
