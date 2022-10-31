package br.com.lfelipels.GeradorMissoes.objectsValue;

public class Route {
    private String from;
    private String to;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        if (to.equals(this.from)) {
            throw new IllegalArgumentException("O endereço de destino deve ser diferente do de origem");
        }

        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
