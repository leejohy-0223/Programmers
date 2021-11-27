package pro49189;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static ArrayList<ArrayList<Integer>> connection = new ArrayList<>();
	static boolean[] visited;
	static int value;
	public int solution(int n, int[][] edge) {
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			connection.add(new ArrayList<>());
		}

		for (int[] ints : edge) {
			connection.get(ints[0]).add(ints[1]);
			connection.get(ints[1]).add(ints[0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);

		value = 1;
		List<Integer> distance = new ArrayList<>();
		visited[1] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Integer poll = queue.poll();

				for (Integer temp : connection.get(poll)) {
					if (!visited[temp]) {
						visited[temp] = true;
						distance.add(value);
						queue.offer(temp);
					}
				}
			}
			value++;
		}

		value -= 2;
		return (int) distance.stream().filter(o -> o == value).count();
	}

	public static void main(String[] args) {

	}
}
