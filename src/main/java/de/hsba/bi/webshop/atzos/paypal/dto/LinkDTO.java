package de.hsba.bi.webshop.atzos.paypal.dto;

import lombok.Data;

@Data
public class LinkDTO {
    private String href;
    private String rel;
    private String method;
}
