package pro42627;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	class Job implements Comparable<Job> {

		int start;
		int process;

		public Job(int start, int process) {
			this.start = start;
			this.process = process;
		}

		@Override
		public int compareTo(Job o) {
			if (this.start == o.start) {
				return this.process - o.process;
			}
			return this.start - o.start;
		}
	}

	public int solution(int[][] jobs) {

		List<Job> jobList = new ArrayList<>();

		for (int[] job : jobs) {
			jobList.add(new Job(job[0], job[1]));
		}

		Collections.sort(jobList);

		Job job = jobList.remove(0);

		int endTime = job.start + job.process; // 처음 태스크의 종료 시간
		int answer = job.process;

		PriorityQueue<Job> readyQueue = new PriorityQueue<>((o1, o2) -> {
			if (o1.process == o2.process) {
				return o1.start - o2.start;
			}
			return o1.process - o2.process;
		});

		boolean chk;
		Job tmp;
		while (jobList.size() > 0) {

			chk = false;

			int tmpIdx = 0;
			// 겹칠 경우,
			while (tmpIdx < jobList.size() && jobList.get(tmpIdx).start < endTime) {
				chk = true;
				readyQueue.add(jobList.get(tmpIdx)); // 작업 큐 목록 만들기
				tmpIdx++;
			}

			if (chk) {
				// 작업 큐 중, 프로세스 시간이 짧은거, 같다면 더 빨리 시작하는거 하나만 처리
				tmp = readyQueue.poll();
				answer += (endTime - tmp.start + tmp.process);
				endTime += tmp.process;
				readyQueue.clear();

			} else {
				// 안 겹치는 경우에는 리스트 맨 앞(빨리 시작하는거) 처리
				tmp = jobList.get(0);
				answer += tmp.process;
				endTime = tmp.start + tmp.process;
			}
			jobList.remove(tmp);
		}

		return answer / jobs.length;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(getBoard("[[0,3],[1,9],[2,6]]", 3, 2)));
		System.out.println(s.solution(getBoard("[[1,4]]", 1, 2)));
		System.out.println(s.solution(getBoard("[[0,10],[4,10],[15,2],[5,11]]", 4, 2))); // 15

	}

	private static int[][] getBoard(String tmp, int isize, int jsize) {
		tmp = tmp.substring(2, tmp.length() - 2);
		int[][] board = new int[isize][jsize];
		String[] split = tmp.split("],\\[");

		for (int i = 0; i < isize; i++) {
			String[] split1 = split[i].split(",");
			for (int j = 0; j < jsize; j++) {
				board[i][j] = Integer.parseInt(split1[j]);
			}
		}
		return board;
	}
}
