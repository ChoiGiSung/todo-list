//
//  ViewController.swift
//  TodoList
//
//  Created by Jun Ho JANG on 2021/04/06.
//

import UIKit

enum Segue {
    static let todo = "toToDoViewController"
    static let doing = "toDoingViewController"
    static let done = "toDoneViewController"
}

class ViewController: UIViewController {
    @IBOutlet weak var firstContainver: UIView!
    @IBOutlet weak var secondContainer: UIView!
    @IBOutlet weak var thirdContainer: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
//        if segue.identifier == Segue.todo {
//            let destVC = segue.destination as! ToDoViewController
//
//        } else if segue.identifier == Segue.doing {
//            let destVC = segue.destination as! DoingViewController
//
//        } else if segue.identifier == Segue.done {
//            let destVC = segue.destination as! DoneViewController
//        }
    }
}