class Dockerfile {

    private String from
    private String maintainer
    private String add
    private String entrypoint

    String from(Map args) {
        String image = args.get('image')
        String version = args.get('version')
        this.from = "FROM $image:$version"
    }

    String maintainer(String value) {
        this.maintainer = "MAINTAINER $value"
    }

    String add(Map args) {
        String source = args.get('source')
        String target = args.get('target')
        this.add = "ADD [\"$source\",\"$target\"]"
    }

    String entrypoint(List<String> values) {
        this.entrypoint = "ENTRYPOINT [${values.collect({ "\"$it\"" }).join(',')}]"
    }

    @Override
    public String toString() {
        "$from\n\n$maintainer\n\n$add\n\n$entrypoint"
    }
}
