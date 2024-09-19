package com.maicon_estudos.curso.entities.enums;

// Enum que representa os diferentes estados de um pedido (OrderStatus)
public enum OrderStatus {
    // Definição dos diferentes status com seus respectivos códigos
    WAITING_PAYMENT(1),  // Aguardando pagamento
    PAID(2),             // Pagamento realizado
    SHIPPED(3),          // Enviado
    DELIVERED(4),        // Entregue
    CANCELED(5);         // Cancelado
    
    // Atributo que armazenará o código do status
    private int code;
    
    // Construtor privado para associar o código ao status
    private OrderStatus(int code) {
        this.code = code;
    }
    
    // Método para retornar o código do status
    public int getCode() {
        return code;
    }

    // Método que retorna o OrderStatus correspondente a um código
    // Se o código não corresponder a nenhum status, lança uma exceção
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        // Exceção lançada caso o código não seja válido
        throw new IllegalArgumentException("Invalid status code");
    }
}
