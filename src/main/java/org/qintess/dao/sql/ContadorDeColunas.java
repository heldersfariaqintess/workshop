package org.qintess.dao.sql;

public final class ContadorDeColunas {
    private int contador;

    private ContadorDeColunas() {
        this.contador = 0;
    }

   static ContadorDeColunas newInstanceContadorDeColunas() {
        return new ContadorDeColunas();
    }

    public int contarIndex() {
        return contador++;
    }
}
