//
//  CustomHeader.swift
//  TodoList
//
//  Created by 조중윤 on 2021/04/10.
//

import UIKit

class CustomHeader: UITableViewHeaderFooterView {
    let title: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.textColor = .white
        return label
    }()
    
    let badge: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.backgroundColor = .clear
        label.layer.cornerRadius = 10
        label.layer.masksToBounds = true
        label.textAlignment = .center
        label.layer.borderColor = UIColor.white.cgColor
        label.layer.borderWidth = 1
        label.textColor = UIColor.white
        return label
    }()
    
    let button: UIButton = {
        let button = UIButton(type: .system)
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setBackgroundImage(UIImage(systemName: "plus"), for: .normal)
        button.tintColor = UIColor.white
        return button
    }()

    override init(reuseIdentifier: String?) {
        super.init(reuseIdentifier: reuseIdentifier)
        configureContents()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configureContents()
    }

    func displayCurrentItemNumberOnBadge(number: Int) {
        self.badge.text = "\(number)"
    }
    
    func configureContents() {
        contentView.addSubview(button)
        contentView.addSubview(badge)
        contentView.addSubview(title)
        contentView.backgroundColor = .clear
        self.backgroundView = UIView()
        self.backgroundView!.backgroundColor = .clear
        contentView.layer.cornerRadius = 30
        contentView.layer.masksToBounds = true
        
        NSLayoutConstraint.activate([
            title.heightAnchor.constraint(equalToConstant: 30),
            title.leadingAnchor.constraint(equalTo: contentView.leadingAnchor,
                   constant: 8),
            title.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
            
            badge.heightAnchor.constraint(equalToConstant: 25),
            badge.widthAnchor.constraint(equalTo: badge.heightAnchor),
            badge.leadingAnchor.constraint(equalTo: title.trailingAnchor, constant: 10),
            badge.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
            
            button.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            button.widthAnchor.constraint(equalToConstant: 30),
            button.heightAnchor.constraint(equalToConstant: 30),
            button.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
        ])
    }
}
