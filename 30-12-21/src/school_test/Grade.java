package school_test;

public class Grade {

	public static final int MIN_SCORE = 40;
	public static final int MAX_SCORE = 100;

	private gradeProfession profession;
	private int score = MIN_SCORE;

	public Grade() {
	}

	public Grade(gradeProfession profession, int score) {
		super();
		this.profession = profession;
		this.score = score;
	}

	public gradeProfession getProfession() {
		return profession;
	}

	public void setProfession(gradeProfession profession) {
		this.profession = profession;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score > MIN_SCORE && score < MAX_SCORE)
			this.score = score;
	}

	public enum gradeProfession {
		MATH, CHEMISTRY, GEOGRAPHY, LITERATURE, PHYSICS, SPORTS;
	}

	@Override
	public String toString() {
		return "profession= " + profession + ", score= " + score;
	}

}
