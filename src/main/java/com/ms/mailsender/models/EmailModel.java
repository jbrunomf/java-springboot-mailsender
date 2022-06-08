package com.ms.mailsender.models;

import com.ms.mailsender.enums.StatusEmail;
import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "EMAIL")
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDate;
    private StatusEmail statusEmail;
}
