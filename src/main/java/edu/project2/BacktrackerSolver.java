package edu.project2;

import java.util.ArrayList;
import java.util.List;

public class BacktrackerSolver implements Solver {
	public BacktrackerSolver() {
	}

	@Override
	public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
		List<Coordinate> solution = new ArrayList<>();
		List<Coordinate> visited = new ArrayList<>();
		backtracker(maze, start, end, solution, visited);
		return solution;
	}

	private boolean backtracker(Maze maze, Coordinate now, Coordinate end, List<Coordinate> solution, List<Coordinate> visited) {
		visited.add(now);
		if (maze.getType(now.col(), now.row()) == Cell.Type.WALL) {
			return false;
		} else if (now.equals(end)) {
			solution.add(now);
			return true;
		}
		List<Coordinate> adjacent = new ArrayList<>();
		if (now.row()+1 < maze.getHeight() && !visited.contains(new Coordinate(now.row()+1, now.col()))) {
			adjacent.add(new Coordinate(now.row()+1, now.col()));
		}
		if (now.col()+1 < maze.getWidth() && !visited.contains(new Coordinate(now.row(), now.col()+1))) {
			adjacent.add(new Coordinate(now.row(), now.col()+1));
		}
		if (now.row()-1 > 0 && !visited.contains(new Coordinate(now.row()-1, now.col()))) {
			adjacent.add(new Coordinate(now.row()-1, now.col()));
		}
		if (now.col()-1 > 0 && !visited.contains(new Coordinate(now.row(), now.col()-1))) {
			adjacent.add(new Coordinate(now.row(), now.col()-1));
		}

		for (Coordinate adj : adjacent) {
			if (backtracker(maze, adj, end, solution, visited)) {
				solution.addFirst(now);
				return true;
			}
		}
		return false;
	}
}