package effective.instance.builder;

public class AlgorithmBuilder {
    private final int score;
    private final int baseline;
    private final int size;
    private final int learningdays;

    public static class Builder{
        private final int score;
        private final int baseline;
        private int size = 10;
        private int learningdays = 7;
        public Builder(int score, int baseline){
            this.score = score;
            this.baseline = baseline;
        }
        public Builder size(int outsize){
            size = outsize;
            return this;
        }
        public Builder learningdays(int day){
            learningdays = day;
            return this;
        }
        public AlgorithmBuilder build(){
            return new AlgorithmBuilder(this);
        }
    }
    public AlgorithmBuilder(Builder builder) {
        score = builder.score;
        baseline = builder.baseline;
        size = builder.size;
        learningdays = builder.learningdays;
    }
}
