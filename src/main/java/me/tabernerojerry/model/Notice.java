package me.tabernerojerry.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "notice_details")
public class Notice {

    @Id
    @SequenceGenerator(
            name = "notice_details_notice_id_seq",
            sequenceName = "notice_details_notice_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="notice_details_notice_id_seq")
    @Column(name = "notice_id")
    private int noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notic_beg_dt")
    private Date noticBegDt;

    @Column(name = "notic_end_dt")
    private Date noticEndDt;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "update_dt")
    private Date updateDt;

}
